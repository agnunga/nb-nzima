/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.bean;

import com.ag.beanI.PriceBeanI;
import com.ag.dao.PriceDao;
import com.ag.model.Price;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author agunga
 */
@Stateless
public class PriceBean implements PriceBeanI {

    @PersistenceContext(unitName = "TheatreManager")
    EntityManager em;

    private PriceDao dao = null;

    public PriceDao getDao() {
        return this.dao = this.dao == null ? new PriceDao(em) : this.dao;
    }

    @Override
    public Price add(Price o) {
        return getDao().save(o);
    }

    @Override
    public Price update(Price o) {
        return getDao().save(o);
    }

    @Override
    public List<Price> findAll() {
        return getDao().findAll();
    }

    @Override
    public Price findById(long id) {
        return getDao().findById(id);
    }

    @Override
    public boolean delete(Price o) {
        return getDao().remove(o);
    }

}
