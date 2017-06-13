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
public interface PurchaseBeanI {

    Purchase add(Purchase p);

    List retrieveAll();

    Purchase retrieve(long id);

    List retrieveByCustomerId(long id);

    Purchase update(Purchase p);

    Boolean delete(Purchase p);

}
