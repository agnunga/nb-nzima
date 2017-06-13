/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.bean;

import com.ag.beanI.UserBeanI;
import com.ag.dao.UserDao;
import com.ag.model.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author agunga
 */
@Stateless
public class UserBean implements UserBeanI {

    Logger jLogger = LoggerFactory.getLogger(User.class);
    @PersistenceContext(unitName = "TheatreManager")
    public EntityManager em;

    private UserDao dao = null;

    public UserDao getDao() {
        return (this.dao == null) ? new UserDao(em) : this.dao;
    }

    @Override
    public User add(User o) {
        return getDao().save(o);
    }

    @Override
    public User update(User o) {
        return getDao().merge(o);
    }

    @Override
    public List<User> findAll() {
        return getDao().findAll();
    }

    @Override
    public User findById(long id) {
        return getDao().findById(id);
    }

    @Override
    public boolean delete(User o) {
        return getDao().remove(o);
    }

    @Override
    public User authenticate(String username, String password) {
        return (User) em.createQuery("SELECT u FROM User u WHERE u.username =:username AND u.password =:password")
                .setParameter("username", username).setParameter("password", password).getSingleResult();
    }

}
