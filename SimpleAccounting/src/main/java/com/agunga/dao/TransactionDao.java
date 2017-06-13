/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agunga.dao;

import com.agunga.model.Transaction;
import javax.persistence.EntityManager;

/**
 *
 * @author agunga
 */
public class TransactionDao extends GenericDao<Transaction, Long> {

    public TransactionDao(EntityManager entityManager) {
        super(Transaction.class, entityManager);
    }

}
