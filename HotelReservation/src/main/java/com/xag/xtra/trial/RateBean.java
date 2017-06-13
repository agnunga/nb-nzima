///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.xag.xtra.trial;
//
//import com.xag.xtra.trial.RateBeanI;
//import com.xag.xtra.trial.RateDao;
//import com.xag.xtra.trial.Rate;
//import java.util.List;
//import javax.ejb.Stateless;
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//
///**
// *
// * @author agunga
// */
//@Stateless
//public class RateBean implements RateBeanI {
//
//    @PersistenceContext(unitName = "HotelReservation")
//    EntityManager em;
//
//    private RateDao dao = null;
//
//    public RateDao getDao() {
//        return this.dao = this.dao == null ? new RateDao(em) : this.dao;
//    }
//
//    @Override
//    public Rate add(Rate o) {
//        return getDao().save(o);
//    }
//
//    @Override
//    public Rate update(Rate o) {
//        return getDao().save(o);
//    }
//
//    @Override
//    public List<Rate> findAll() {
//        return getDao().findAll();
//    }
//
//    @Override
//    public Rate findById(long id) {
//        return getDao().findById(id);
//    }
//
//    @Override
//    public boolean delete(Rate o) {
//        return getDao().remove(o);
//    }
//
//}
