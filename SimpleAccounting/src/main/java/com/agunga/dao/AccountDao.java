/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agunga.dao;

import com.agunga.model.Account;
import javax.persistence.EntityManager;

/**
 *
 * @author agunga
 */
public class AccountDao extends GenericDao<Account, Long> {

    public AccountDao(EntityManager entityManager) {
        super(Account.class, entityManager);
    }
}
