/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.factory;
 
import com.ag.model.Partner;
import com.ag.model.PrimaryTeacher;
import com.ag.model.SecondaryTeacher;
import com.ag.model.Teacher;

/**
 *
 * @author agunga
 */
public class TeacherFactory implements AbstractFactory{

    String t;

    public TeacherFactory(String t) { 
        this.t = t;
    }

    @Override
    public Partner getPartner() {
        if (t.equals("PT")) {
            return new PrimaryTeacher();
        }
        return new SecondaryTeacher();
    }
 
}
