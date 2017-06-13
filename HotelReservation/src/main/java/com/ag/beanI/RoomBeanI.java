/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.beanI;

import com.ag.model.Hotel;
import com.ag.model.Room;
import com.ag.model.Reservation;
import com.ag.model.Section;
import com.xag.util.NoMatchFound;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author agunga
 */
@Local
public interface RoomBeanI {

    /**
     * @param o is the object to be updated
     * @return the added Room
     */
    Room add(Room o);

    /**
     *
     * @param o is the object to be updated
     * @return the updated Room
     */
    Room update(Room o);

    /**
     *
     * @param id is the primary key
     * @param o is the object to be updated
     * @return the updated Room
     */
//    Room update(long id, Room o);
    /**
     *
     * @author agunga
     * @return a List of Rooms
     */
    List<Room> findAll();

    /**
     *
     * @author agunga
     * @param o is the primaryId
     * @return a Room object
     * @throws com.xag.util.NoMatchFound
     */
    Room findById(long o) throws NoMatchFound;

    /**
     *
     * @author agunga
     * @param id is the primaryId
     * @return true if the deletion was successful
     */
    boolean delete(Room id);

    /**
     *
     * @author agunga
     * @param id is the primaryId
     * @return the number of deleted records
     */
    int delete(long id);

    /**
     *
     * @return
     */
    List<Room> getUnoccupiedRooms(Hotel h, Section s);

    /**
     *
     * @return
     */
    List<Room> getOccupiedRooms(Hotel h, Section s);

    /**
     *
     * @param id
     * @return
     */
    boolean checkIn(long id);

    /**
     *
     * @param id
     * @return
     */
    boolean checkOut(long id);

    /**
     *
     * @param rt
     * @return Reservation created
     */
    Reservation bookRoom(Reservation rt);

    /**
     *
     * @param rt
     * @return true if Room isAvailable
     */
    boolean isRoomAvailable(Reservation rt);
}
