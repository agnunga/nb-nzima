/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.factory;

import com.ag.dao.GenericDao;
import com.ag.dao.HotelDao;
import com.ag.dao.ReservationDao;
import com.ag.dao.RoomDao;
import com.ag.dao.SectionDao;
import com.ag.dao.UserDao;
import javax.persistence.EntityManager;

/**
 *
 * @author agunga
 */
public class DaoFactory implements AbstractFactory {

    DaoType type;

    public DaoFactory(DaoType type) {
        this.type = type;
    }

    DaoFactory() {
    }

    public GenericDao getDao(EntityManager em) {
        switch (type) {
            case HOTEl: {
                return new HotelDao(em);
            }
            case RESERVATION: {
                return new ReservationDao(em);
            }
            case ROOM: {
                return new RoomDao(em);
            }
            case SECTION: {
                return new SectionDao(em);
            }
            case USER: {
                return new UserDao(em);
            }
            default:
                return null;
        }
    }

    public GenericDao getDao(DaoType type, EntityManager em) {
        return new DaoFactory(type).getDao(em);
    }
}
