/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agunga.bean;

import com.agunga.beanI.AccountantBeanI;
import com.agunga.beanI.OperationBeanI;
import com.agunga.beanI.TransactionBeanI;
import com.agunga.model.Accountant;
import javax.ejb.EJB;
import javax.ejb.Local;

/**
 *
 * @author agunga
 */
@Local
public class OperationBean implements OperationBeanI {

    @EJB
    AccountantBeanI abi;
    @EJB
    TransactionBeanI tbi;

    @Override
    public Accountant authentication(String username, String pasword) {
        return abi.findByUsernameAndPassword(username, pasword);
    }

}
