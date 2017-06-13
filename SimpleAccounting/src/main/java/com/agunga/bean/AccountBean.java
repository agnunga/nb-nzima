/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agunga.bean;

import com.agunga.beanI.*;
import com.agunga.dao.AccountDao;
import com.agunga.model.Account;
import java.util.List;
import javax.ejb.Local;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author agunga
 */
@Local
public class AccountBean implements AccountBeanI {

    @PersistenceContext(unitName = "SimpleAccounting")
    EntityManager em;
    AccountDao ad = new AccountDao(em);

    @Override
    public Account add(Account a) {
        return ad.save(a);
    }

    @Override
    public Account edit(Account a) {
        return ad.merge(a);
    }

    @Override
    public List findAll() {
        return ad.findAll();
    }

}
