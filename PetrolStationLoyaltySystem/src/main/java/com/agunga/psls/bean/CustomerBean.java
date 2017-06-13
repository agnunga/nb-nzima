/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agunga.psls.bean;

import com.agunga.psls.beanI.CustomerBeanI;
import com.agunga.psls.beanI.PurchaseBeanI;
import com.agunga.psls.dao.CustomerDao;
import com.agunga.psls.model.Customer;
import com.agunga.psls.model.Purchase;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author agunga
 */
@Stateless
public class CustomerBean implements CustomerBeanI {

    @EJB
    PurchaseBeanI purchaseBeanI;

    @PersistenceContext(unitName = "PSLS")
    EntityManager em;

    CustomerDao customerDao = new CustomerDao(em);

    @Override
    public Customer add(Customer customer) {
        return customerDao.save(customer);
    }

    public boolean registerCustomer(Customer customer, Purchase p) {
        return (add(customer) != null && givePoints(p) != null);
    }

    @Override
    public Purchase givePoints(Purchase p) {
        return purchaseBeanI.add(p);
    }

    @Override
    public List retrieveAll() {
        return customerDao.findAll();
    }

    @Override
    public Customer retrieve(long id) {
        return customerDao.findById(id);
    }

    @Override
    public Customer update(Customer customer) {
        return customerDao.merge(customer);
    }

    @Override
    public Boolean delete(Customer customer) {
        return customerDao.remove(customer);
    }

    @Override
    public Purchase redeemPoints(Purchase p) {
        if (p.getNumberOfPoints() <= checkPoints(p.getVehicleRegNo())) {
            p.setNumberOfPoints(-1 * p.getNumberOfPoints());
            return purchaseBeanI.add(p);
        } else {
            return null;
        }
    }

    @Override
    public long checkPoints(long id) {
        List<Purchase> points = retrievePurchaseHistory(id);
        long noOfPoints = 0;
        Iterator<Purchase> i = points.iterator();
        while (i.hasNext()) {
            Purchase p = i.next();
            noOfPoints += p.getNumberOfPoints();
        }
        return noOfPoints;
    }

    @Override
    public List retrievePurchaseHistory(long id) {
        Customer customer = retrieve(id);
        return purchaseBeanI.retrieveByCustomerId(customer.getId());
    }
}
