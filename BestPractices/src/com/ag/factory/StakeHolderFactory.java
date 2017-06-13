/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.factory;

/**
 *
 * @author agunga
 */
public class StakeHolderFactory {

    private final String t;
    private final String t1;

    public StakeHolderFactory(String t, String t1) {
        this.t = t;
        this.t1 = t1;
    }

    public AbstractFactory getAbstractFactory() {
        if (t.equals("SF")) {
            return new StudentFactory(t1);
        }
        return new TeacherFactory(t1);
    }
}
