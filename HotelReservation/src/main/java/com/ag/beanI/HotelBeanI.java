/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.beanI;

import com.ag.model.Hotel;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author agunga
 */
@Local
public interface HotelBeanI {

    /**
     *
     * @return
     */
    Hotel add(Hotel o);

    /**
     *
     * @param o
     * @return
     */
    Hotel update(Hotel o);

    /**
     *
     * @return
     */
    List<Hotel> findAll();

    /**
     *
     * @param id
     * @return
     */
    Hotel findById(long id);

    /**
     *
     * @param o
     * @return
     */
    boolean delete(Hotel o);
}
