/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agunga.bean;

import com.agunga.beanI.AccountantBeanI;
import com.agunga.dao.AccountantDao;
import com.agunga.model.Accountant;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author agunga
 */
public class AccountantBean implements AccountantBeanI {

    @PersistenceContext(unitName = "SimpleAccounting")
    EntityManager em;
    AccountantDao ad = new AccountantDao(em);

    @Override
    public Accountant add(Accountant a) {
        return ad.save(a);
    }

    @Override
    public Accountant edit(Accountant a) {
        return ad.merge(a);
    }

    @Override
    public boolean delete(Accountant a) {
        return ad.remove(a);
    }

    @Override
    public Accountant findByUsernameAndPassword(String username, String password) {
        return (Accountant) em.createNamedQuery("findByUsernameAndPassword").setParameter("username", username).setParameter("password", password).getSingleResult();
    }
}
