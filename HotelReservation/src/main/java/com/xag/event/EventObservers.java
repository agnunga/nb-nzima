/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xag.event;

import com.ag.model.User;
import javax.enterprise.event.Observes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author agunga
 */
public class EventObservers {

    Logger logger = LoggerFactory.getLogger(User.class);
    String message = "1 event executed!!";

    public void myOnPageLoad(@Observes OnLoginFailEvent event) {
        System.out.println(message);
        System.out.println(event.takeAction());
    }

    public void myOnPageLoad(@Observes AnotherEvent event) {
        System.out.println(message);
        System.out.println(event.takeAction());
    }
}
