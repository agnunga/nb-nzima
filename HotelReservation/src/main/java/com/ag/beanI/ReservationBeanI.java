/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.beanI;

import com.ag.model.Room;
import com.ag.model.Reservation;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author agunga
 */
@Local
public interface ReservationBeanI {

    /**
     * @param o is the object to be updated
     * @return the added Reservation
     */
    Reservation add(Reservation o);

    /**
     *
     * @param o is the object to be updated
     * @return the updated Reservation
     */
    Reservation update(Reservation o);

    /**
     *
     * @author agunga
     * @return a List of RoomTrackers
     */
    List<Reservation> findAll();

    /**
     *
     * @author agunga
     * @param o is the primaryId
     * @return a Reservation object
     */
    Reservation findById(long o);

    /**
     *
     * @author agunga
     * @param id is the primaryId
     * @return true if the deletion was successful
     */
    boolean delete(Reservation id);

    /**
     *
     * @author agunga
     * @param id is the primaryId
     * @return the number of deleted records
     */
    int delete(long id);

    /**
     *
     * @param room
     * @return
     */
    List<Reservation> findByRoom(Room room);

}
