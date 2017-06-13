/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.beanI;

import com.ag.model.Price;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author agunga
 */
@Local
public interface PriceBeanI {

    Price add(Price o);

    Price update(Price o);

    List<Price> findAll();

    Price findById(long o);

    boolean delete(Price id);
}
