/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agunga.psls.event;

import javax.ejb.Local;

/**
 *
 * @author agunga
 */
@Local
public class MyEvent implements MyEventI {

    @Override
    public String onRegistration() {
        return "";
    }

    @Override
    public String onAcquire() {
        return "";
    }

    @Override
    public String onRedeem() {
        return "";
    }

    @Override
    public String onCheckBalance() {
        return "";
    }

}
