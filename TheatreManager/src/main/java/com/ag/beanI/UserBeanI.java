/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.beanI;

import com.ag.model.User;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author agunga
 */
@Local
public interface UserBeanI {

    User add(User o);

    User update(User o);

    List<User> findAll();

    User findById(long id);

    boolean delete(User o);

    User authenticate(String username, String password);
}
