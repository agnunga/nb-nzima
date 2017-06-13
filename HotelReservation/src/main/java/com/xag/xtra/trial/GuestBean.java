///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.xag.xtra.trial;
//
//import com.ag.beanI.RoomBeanI;
//import com.xag.xtra.trial.GuestBeanI;
//import com.xag.xtra.trial.GuestDao;
//import com.ag.model.Reservation;
//import com.xag.xtra.trial.Guest;
//import com.xag.event.EventResource;
//import com.xag.event.OnLoginFailEvent;
//import com.xag.util.BcryptPassword;
//import static com.xag.util.BcryptPassword.checkPassword;
//import java.util.List;
//import javax.ejb.EJB;
//import javax.ejb.Stateless;
//import javax.enterprise.event.Event;
//import javax.inject.Inject;
//import javax.inject.Named;
//import javax.persistence.EntityManager;
//import javax.persistence.NoResultException;
//import javax.persistence.PersistenceContext;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
///**
// *
// * @author agunga
// */
//@Stateless
//public class GuestBean implements GuestBeanI {
//
//    @EJB
//    RoomBeanI rbi;
//
//    Logger jLogger = LoggerFactory.getLogger(Guest.class);
//    @PersistenceContext(unitName = "HotelReservation")
//    public EntityManager em;
//
//    private GuestDao dao = null;
//
//    public GuestDao getDao() {
//        return (this.dao == null) ? new GuestDao(em) : this.dao;
//    }
//
//    @Override
//    public Guest add(Guest o) {
//        o.setPassword(BcryptPassword.hashPassword(o.getPassword()));
//        return getDao().save(o);
//    }
//
//    @Override
//    public Guest update(Guest o) {
//        return getDao().merge(o);
//    }
//
//    @Override
//    public List<Guest> findAll() {
//        return getDao().findAll();
//    }
//
//    @Override
//    public Guest findById(long id) {
//        return getDao().findById(id);
//    }
//
//    @Override
//    public boolean delete(Guest o) {
//        return getDao().remove(o);
//    }
//
//    @Inject
//    @Named("onLoginFail")
//    Event<EventResource> e;
//
//    @Override
//    public Guest authenticate(String username, String password) {
////        String hashedPassword = BcryptPassword.hashPassword(password);
//
//        Logger logger = LoggerFactory.getLogger("Login");
//        try {
//            Guest u = (Guest) em.createQuery("SELECT u FROM Guest u WHERE u.username =:username ")
//                    .setParameter("username", username).getSingleResult();
//
//            logger.warn("After Query!");
//
//            if (u != null) {
//                if (checkPassword(password, u.getPassword())) {
//                    logger.warn("Login success!");
//                    return u;
//                }
//            }
//        } catch (NoResultException nre) {
//            logger.warn("Login failed at nre exception");
//            e.fire(new OnLoginFailEvent());
//            logger.warn("After OnLoginFailEvent!");
//            return null;
//        }
//        logger.warn("Login failed out of catch block");
//        e.fire(new OnLoginFailEvent());
//        return null;
//    }
//
//    @Override
//    public boolean changePassword(String username, String password, String newPassword
//    ) {
//        Guest u = authenticate(username, password);
//        if (u == null) {
//            return false;
//        }
//        String hashedNewPassword = BcryptPassword.hashPassword(newPassword);
//        int update = em.createQuery("UPDATE Guest u SET u.password = " + hashedNewPassword + " WHERE u.username =:username ")
//                .setParameter("username", username).executeUpdate();
//        return update == 1;
//    }
//
//    @Override
//    public Reservation bookRoom(Reservation booking) {
//        return rbi.bookRoom(booking);
//    }
//
//}
