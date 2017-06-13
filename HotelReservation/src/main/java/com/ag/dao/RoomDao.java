/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.dao;

import com.ag.model.Room;
import javax.persistence.EntityManager;

/**
 *
 * @author agunga
 */
public class RoomDao extends GenericDao<Room, Long> {

    public RoomDao(EntityManager entityManager) {
        super(Room.class, entityManager);
    }

    public int deleteById(EntityManager em, long id) {
        return em.createNamedQuery("deleteRoomById").setParameter("id", id).executeUpdate();
    }
}
