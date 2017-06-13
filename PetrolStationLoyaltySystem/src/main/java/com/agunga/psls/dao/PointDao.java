/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agunga.psls.dao;

import com.agunga.psls.model.Purchase;
import javax.persistence.EntityManager;

/**
 *
 * @author agunga
 */
public class PointDao extends GenericDao<Purchase, Long> {

    public PointDao(EntityManager entityManager) {
        super(Purchase.class, entityManager);
    }
}
