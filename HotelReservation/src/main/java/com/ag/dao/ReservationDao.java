/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.dao;
 
import com.ag.model.Reservation;
import javax.persistence.EntityManager;

/**
 *
 * @author agunga
 */
public class ReservationDao extends GenericDao<Reservation, Long> {

    public ReservationDao(EntityManager entityManager) {
        super(Reservation.class, entityManager);
    }

}
