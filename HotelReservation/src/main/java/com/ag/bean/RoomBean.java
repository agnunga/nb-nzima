/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.bean;

import com.ag.beanI.RoomBeanI;
import com.ag.beanI.ReservationBeanI;
import com.ag.dao.RoomDao;
import com.ag.factory.DaoFactory;
import com.ag.factory.DaoType;
import com.ag.model.Hotel;
import com.ag.model.Room;
import com.ag.model.Reservation;
import com.ag.model.Section;
import com.xag.util.NoMatchFound;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author agunga
 */
@Stateless
public class RoomBean implements RoomBeanI {
    
    @PersistenceContext(unitName = "HotelReservation")
    EntityManager em;
    
    Logger jLogger;
    
    @EJB
    ReservationBeanI bbi;
    
    @PostConstruct
    private void setLogger() {
        jLogger = LoggerFactory.getLogger(Room.class);
    }
    
    public RoomDao getDao() {
        return (RoomDao) new DaoFactory(DaoType.ROOM).getDao(em);
    }
    
    @Override
    public Room add(Room o) {
        try {
            return getDao().save(o);
        } catch (Exception e) {
            return null;
        }
    }
    
    @Override
    public Room update(Room o) {
        try {
            return getDao().merge(o);
        } catch (Exception e) {
            return null;
        }
    }
    
    @Override
    public List<Room> findAll() {
        return getDao().findAll();
    }
    
    @Override
    public Room findById(long id) throws NoMatchFound {
        return getDao().findById(id);
    }
    
    @Override
    public boolean delete(Room o) {
        return getDao().remove(o);
    }
    
    @Override
    public int delete(long id) {
        return getDao().deleteById(em, id);
    }
    
    private List<Room> getRoomByStatus(int status, Hotel h, Section s) {
        return this.em.createQuery("SELECT m FROM Room  m WHERE m.status = :status")
                .setParameter("status", status).getResultList();
        
    }
    
    @Override
    public List<Room> getOccupiedRooms(Hotel h, Section s) {
        
        return getRoomByStatus(1, h, s);
        
    }
    
    @Override
    public List<Room> getUnoccupiedRooms(Hotel h, Section s) {
        return getRoomByStatus(0, h, s);
        
    }
    
    private int checkInOut(long id, int status) {
        return this.em.createQuery("UPDATE Room r SET r.status = " + status + " WHERE r.id = :id")
                .setParameter("id", id).executeUpdate();
    }
    
    @Override
    public boolean checkIn(long id) {
        return checkInOut(id, 1) > 0;
        
    }
    
    @Override
    public boolean checkOut(long id) {
        return checkInOut(id, 0) > 0;
    }
    
    @Override
    public boolean isRoomAvailable(Reservation rt) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        
        LocalDateTime checkInDate = LocalDateTime.parse(rt.getCheckIn(), formatter);
        LocalDateTime checkOutDate = LocalDateTime.parse(rt.getCheckOut(), formatter);
        if (checkInDate.isAfter(checkOutDate)) {
            return false;
        }
        List<Reservation> trackers = bbi.findByRoom(rt.getRoom());
        Iterator<Reservation> i = trackers.iterator();
        int count = 0;
        while (i.hasNext()) {
            Reservation rt1 = i.next();
            
            LocalDateTime checkInDate1 = LocalDateTime.parse(rt1.getCheckIn(), formatter);
            LocalDateTime checkOutDate1 = LocalDateTime.parse(rt1.getCheckOut(), formatter);
            
            if (checkOutDate.isBefore(checkInDate1) || checkInDate.isAfter(checkOutDate1)) {
                count++;
            }
        }
        return count == trackers.size();
    }
    
    @Override
    public Reservation bookRoom(Reservation rt) {
        if (isRoomAvailable(rt)) {
            return bbi.add(rt);
        }
        return null;
    }
    
}
