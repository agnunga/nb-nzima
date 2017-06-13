/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agunga.beanI;

import com.agunga.model.Transaction;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author agunga
 */
@Local
public interface TransactionBeanI {

    public Transaction add(Transaction t);

    public List findByAccountantId(long accountantId);
}
