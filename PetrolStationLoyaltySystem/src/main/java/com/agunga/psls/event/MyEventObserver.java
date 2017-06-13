/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agunga.psls.event;

import javax.enterprise.event.Observes;

/**
 *
 * @author agunga
 */
public class MyEventObserver {

    public void onRegistration(@Observes MyEvent event) {
        event.onRegistration();
    }

    public void onAcquire(@Observes MyEvent event) {
        event.onAcquire();
    }

    public void onRedeem(@Observes MyEvent event) {
        event.onRedeem();
    }

    public void onCheckBalance(@Observes MyEvent event) {
        event.onCheckBalance();
    }

}
