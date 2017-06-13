/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.bean;

import com.ag.beanI.HotelBeanI;
import com.ag.dao.HotelDao;
import com.ag.factory.DaoFactory;
import com.ag.factory.DaoType;
import com.ag.model.Hotel;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author agunga
 */
@Stateless
public class HotelBean implements HotelBeanI {

    @PersistenceContext(unitName = "HotelReservation")
    EntityManager em;

    public HotelDao getDao() {
        return (HotelDao) new DaoFactory(DaoType.HOTEl).getDao(em);
    }

    @Override
    public Hotel add(Hotel o) {
        return getDao().save(o);
    }

    @Override
    public Hotel update(Hotel o) {
        return getDao().save(o);
    }

    @Override
    public List<Hotel> findAll() {
        return getDao().findAll();
    }

    @Override
    public Hotel findById(long id) {
        return getDao().findById(id);
    }

    @Override
    public boolean delete(Hotel o) {
        return getDao().remove(o);
    }

}
