/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.dao;

import com.ag.model.User;
import javax.persistence.EntityManager;

/**
 *
 * @author agunga
 */
public class UserDao extends GenericDao<User, Long> {

    public UserDao(EntityManager entityManager) {
        super(User.class, entityManager);
    }

}
