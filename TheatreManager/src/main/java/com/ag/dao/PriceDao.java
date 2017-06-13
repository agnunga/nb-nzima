/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.dao;

import com.ag.model.Price;
import javax.persistence.EntityManager;

/**
 *
 * @author agunga
 */
public class PriceDao extends GenericDao<Price, Long> {

    public PriceDao(EntityManager entityManager) {
        super(Price.class, entityManager);
    }

}
