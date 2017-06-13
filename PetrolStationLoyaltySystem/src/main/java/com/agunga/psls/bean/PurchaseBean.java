/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agunga.psls.bean;

import com.agunga.psls.beanI.PurchaseBeanI;
import com.agunga.psls.dao.PointDao;
import com.agunga.psls.model.Purchase;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author agunga
 */
@Stateless
public class PurchaseBean implements PurchaseBeanI {

    @PersistenceContext(unitName = "PSLS")
    EntityManager em;

    PointDao pointDao = new PointDao(em);

    @Override
    public Purchase add(Purchase p) {
        p.setNumberOfPoints(p.getLitresPurchased());
        return pointDao.save(p);
    }

    @Override
    public List retrieveAll() {
        return pointDao.findAll();
    }

    @Override
    public Purchase retrieve(long id) {
        return pointDao.findById(id);
    }

    @Override
    public List retrieveByCustomerId(long id) {
        em.createNamedQuery("findByCustomerId").setParameter("id", id).getResultList();
        return null;
    }

    @Override
    public Purchase update(Purchase p) {
        return pointDao.merge(p);

    }

    @Override
    public Boolean delete(Purchase p) {
        return pointDao.remove(p);

    }

}
