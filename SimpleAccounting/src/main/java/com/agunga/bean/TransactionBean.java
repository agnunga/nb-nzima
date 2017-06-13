/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agunga.bean;

import com.agunga.beanI.TransactionBeanI;
import com.agunga.dao.TransactionDao;
import com.agunga.model.Transaction;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author agunga
 */
@Stateless
public class TransactionBean implements TransactionBeanI {

    @PersistenceContext(unitName = "SimpleAccounting")
    EntityManager em;
    TransactionDao td = new TransactionDao(em);

    @Override
    public Transaction add(Transaction t) {
        return td.save(t);
    }

    @Override
    public List findByAccountantId(long accountantId) {
        return em.createNamedQuery("findByAccountantId").setParameter("id", accountantId).getResultList();
    }
}
