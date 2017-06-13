/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.dao;

import com.ag.model.Hotel;
import javax.persistence.EntityManager;

/**
 *
 * @author agunga
 */
public class HotelDao extends GenericDao<Hotel, Long> {

    public HotelDao(EntityManager entityManager) {
        super(Hotel.class, entityManager);
    }
}
