/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agunga.beanI;

import com.agunga.model.Account;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author agunga
 */
@Local
public interface AccountBeanI {

    public Account add(Account a);

    public Account edit(Account a);

    public List findAll();
}
