/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.bean;

import com.ag.beanI.SectionBeanI; 
import com.ag.dao.SectionDao;
import com.ag.factory.DaoFactory;
import com.ag.factory.DaoType;
import com.ag.model.Section;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author agunga
 */
@Stateless
public class SectionBean implements SectionBeanI {

    @PersistenceContext(unitName = "HotelReservation")
    EntityManager em;

    public SectionDao getDao() {
        return (SectionDao) new DaoFactory(DaoType.SECTION).getDao(em);
    }

    @Override
    public Section add(Section o) {
        return getDao().save(o);
    }

    @Override
    public Section update(Section o) {
        return getDao().save(o);
    }

    @Override
    public List<Section> findAll() {
        return getDao().findAll();
    }

    @Override
    public Section findById(long id) {
        return getDao().findById(id);
    }

    @Override
    public boolean delete(Section o) {
        return getDao().remove(o);
    }

}
