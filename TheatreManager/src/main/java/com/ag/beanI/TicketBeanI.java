/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.beanI;

import com.ag.model.Ticket;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author agunga
 */
@Local
public interface TicketBeanI {

    Ticket add(Ticket o);

    Ticket update(Ticket o);

    List<Ticket> findAll();

    Ticket findById(long o);

    boolean delete(Ticket id);
}
