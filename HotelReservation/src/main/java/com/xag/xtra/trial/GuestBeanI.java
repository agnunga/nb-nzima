///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.xag.xtra.trial;
//
//import com.ag.model.Reservation;
//import com.xag.xtra.trial.Guest;
//import java.util.List;
//import javax.ejb.Local;
//
///**
// *
// * @author agunga
// */
//@Local
//public interface GuestBeanI {
//
//    /**
//     *
//     * @param o
//     * @return
//     */
//    Guest add(Guest o);
//
//    /**
//     *
//     * @param o
//     * @return
//     */
//    Guest update(Guest o);
//
//    /**
//     *
//     * @return
//     */
//    List<Guest> findAll();
//
//    /**
//     *
//     * @param id
//     * @return
//     */
//    Guest findById(long id);
//
//    /**
//     *
//     * @param o
//     * @return
//     */
//    boolean delete(Guest o);
//
//    /**
//     *
//     * @param username
//     * @param password
//     * @return
//     */
//    Guest authenticate(String username, String password);
//
//    /**
//     *
//     * @param username
//     * @param password
//     * @param newPassword
//     * @return
//     */
//    boolean changePassword(String username, String password, String newPassword);
//
//    /**
//     *
//     * @param booking
//     * @return
//     */
//    Reservation bookRoom(Reservation booking);
//}
