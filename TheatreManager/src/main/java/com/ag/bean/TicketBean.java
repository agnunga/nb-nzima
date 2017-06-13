/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.bean;

import com.ag.beanI.TicketBeanI;
import com.ag.dao.TicketDao;
import com.ag.model.Ticket;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author agunga
 */
@Stateless
public class TicketBean implements TicketBeanI {

    @PersistenceContext(unitName = "TheatreManager")
    EntityManager em;

    private TicketDao dao = null;

    public TicketDao getDao() {
        return this.dao = (this.dao == null) ? new TicketDao(em) : this.dao;
    }

    @Override
    public Ticket add(Ticket o) {
        return getDao().save(o);
    }

    @Override
    public Ticket update(Ticket o) {
        return getDao().save(o);
    }

    @Override
    public List<Ticket> findAll() {
        return getDao().findAll();
    }

    @Override
    public Ticket findById(long id) {
        return getDao().findById(id);
    }

    @Override
    public boolean delete(Ticket o) {
        return getDao().remove(o);
    }

}
