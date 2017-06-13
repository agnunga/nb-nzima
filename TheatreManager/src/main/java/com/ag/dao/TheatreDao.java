/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.dao;

import com.ag.model.Theatre;
import javax.persistence.EntityManager;

/**
 *
 * @author agunga
 */
public class TheatreDao extends GenericDao<Theatre, Long> {

    public TheatreDao(EntityManager entityManager) {
        super(Theatre.class, entityManager);
    }
}
