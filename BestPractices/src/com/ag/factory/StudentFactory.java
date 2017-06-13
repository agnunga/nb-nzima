/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.factory;

import com.ag.model.NormalStudent;
import com.ag.model.Partner;
import com.ag.model.SpecialStudent; 

/**
 *
 * @author agunga
 */
public class StudentFactory implements AbstractFactory {

    String t;

    public StudentFactory(String t) {
        this.t = t;
    }

    @Override
    public Partner getPartner() {
        if (t.equals("NS")) {
            return new NormalStudent();
        }
        return new SpecialStudent();
    }
}
