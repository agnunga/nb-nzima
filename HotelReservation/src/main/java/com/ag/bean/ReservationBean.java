/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.bean;

import com.ag.beanI.RoomBeanI;
import com.ag.beanI.ReservationBeanI; 
import com.ag.dao.ReservationDao;
import com.ag.factory.DaoFactory;
import com.ag.factory.DaoType;
import com.ag.model.Room;
import com.ag.model.Reservation;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author agunga
 */
@Stateless
public class ReservationBean implements ReservationBeanI {

    @PersistenceContext(unitName = "HotelReservation")
    EntityManager em;

    @EJB
    RoomBeanI rbi;

    public ReservationDao getDao() {
        return (ReservationDao) new DaoFactory(DaoType.RESERVATION).getDao(em);
    }

    @Override
    public Reservation add(Reservation o) {
        try {
            return getDao().save(o);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Reservation update(Reservation o) {
        try {
            return getDao().merge(o);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Reservation> findAll() {
        return getDao().findAll();
    }

    @Override
    public Reservation findById(long id) {
        return getDao().findById(id);
    }

    @Override
    public boolean delete(Reservation o) {
        return getDao().remove(o);
    }

    @Override
    public int delete(long id) {
        return this.em.createQuery("DELETE FROM Reservation r WHERE r.id = :id")
                .setParameter("id", id).executeUpdate();
    }

    @Override
    public List<Reservation> findByRoom(Room room) {
        return this.em.createQuery("SELECT r FROM Reservation r WHERE r.room = :room")
                .setParameter("room", room).getResultList();
    }

}
