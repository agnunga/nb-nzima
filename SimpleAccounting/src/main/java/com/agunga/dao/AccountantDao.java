/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agunga.dao;

import com.agunga.model.Accountant;
import javax.persistence.EntityManager;

/**
 *
 * @author agunga
 */
public class AccountantDao  extends GenericDao<Accountant, Long> {

    public AccountantDao(EntityManager entityManager) {
        super(Accountant.class, entityManager);
    }
}
