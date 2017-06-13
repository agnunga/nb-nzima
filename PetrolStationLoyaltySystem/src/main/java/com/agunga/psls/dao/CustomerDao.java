/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agunga.psls.dao;

import com.agunga.psls.model.Customer;
import javax.persistence.EntityManager;

/**
 *
 * @author agunga
 */
public class CustomerDao extends GenericDao<Customer, Long> {

    public CustomerDao(EntityManager entityManager) {
        super(Customer.class, entityManager);
    }
}
