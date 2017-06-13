/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agunga.psls.beanI;

import com.agunga.psls.model.Customer;
import com.agunga.psls.model.Purchase;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author agunga
 */
@Local
public interface CustomerBeanI {

    Customer add(Customer customer);

    Purchase givePoints(Purchase p);

    List retrieveAll();

    Customer retrieve(long id);

    Customer update(Customer customer);

    Boolean delete(Customer customer);

    Purchase redeemPoints(Purchase p);

    long checkPoints(long id);

    List retrievePurchaseHistory(long id);
}
