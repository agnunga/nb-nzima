/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agunga.psls.event;

import javax.ejb.Stateless;

/**
 *
 * @author agunga
 */
@Stateless
public interface MyEventI {

    String onRegistration();

    String onAcquire();

    String onRedeem();

    String onCheckBalance();
}
