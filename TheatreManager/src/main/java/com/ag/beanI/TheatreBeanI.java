/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.beanI;

import com.ag.model.Theatre;
import java.time.LocalDateTime;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author agunga
 */
@Local
public interface TheatreBeanI {

    Theatre add(Theatre o);

    Theatre update(Theatre o);

    List<Theatre> findAll();
    
    Theatre findById(long id);

    boolean delete(Theatre o);

    double retrieveDailyRevenue(long theatreId, LocalDateTime day);
}
