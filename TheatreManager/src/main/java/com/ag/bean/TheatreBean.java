/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.bean;

import com.ag.beanI.TheatreBeanI;
import com.ag.dao.TheatreDao;
import com.ag.model.Price;
import com.ag.model.Theatre;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author agunga
 */
@Stateless
public class TheatreBean implements TheatreBeanI {

    @PersistenceContext(unitName = "TheatreManager")
    EntityManager em;

    private TheatreDao dao = null;

    public TheatreDao getDao() {
        return this.dao = this.dao == null ? new TheatreDao(em) : this.dao;
    }

    @Override
    public Theatre add(Theatre o) {
        return getDao().save(o);
    }

    @Override
    public Theatre update(Theatre o) {
        return getDao().save(o);
    }

    @Override
    public List<Theatre> findAll() {
        return getDao().findAll();
    }

    @Override
    public Theatre findById(long id) {
        return getDao().findById(id);
    }

    @Override
    public boolean delete(Theatre o) {
        return getDao().remove(o);
    }

    private double findRevenueForAPeriod(long theatreId, LocalDateTime starting, LocalDateTime ending) {
        double totalRevenue = 0.0;

        Theatre theatre = findById(theatreId);

        List<Price> prices = em.createQuery("SELECT p FROM Price p WHERE p.startDateTime  <= :starting "
                + "AND p.startDateTime >= :ending "
                + "AND p.theatre = :theatre")
                .setParameter("starting", starting)
                .setParameter("ending", ending)
                .setParameter("theatre", theatre)
                .getResultList();

        Iterator<Price> i = prices.iterator();
        while (i.hasNext()) {
            Price p = new Price();
            totalRevenue += p.getAmount();
        }
        return totalRevenue;
    }

//    String str = "1986-04-08 12:30";
//    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
//    LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
    @Override
    public double retrieveDailyRevenue(long theatreId, LocalDateTime specificDay) {
        int year = LocalDateTime.now().getYear();
        int month = LocalDateTime.now().getMonth().getValue();
        int day = LocalDateTime.now().getDayOfMonth();

        String str = year + "-" + month + "-" + day + " 00:00";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(str, formatter);

        return findRevenueForAPeriod(theatreId, dateTime, dateTime.plusDays(1));
    }

}
