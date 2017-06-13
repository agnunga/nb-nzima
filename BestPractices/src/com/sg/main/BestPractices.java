/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.main;

import com.ag.factory.StakeHolderFactory;
import com.ag.factory.StudentFactory;
import com.ag.factory.TeacherFactory;
import com.ag.model.NormalStudent;
import com.ag.model.PrimaryTeacher;
import com.ag.model.SecondaryTeacher;
import com.ag.model.SpecialStudent;
import com.ag.factory.AbstractFactory;

/**
 *
 * @author agunga
 */
public class BestPractices {

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String[] args) {
//        /* 
//         NormalStudent ns = (NormalStudent) new StudentFactory(NormalStudent.class).getStudentFactory();
//         ns.setName("Oloo");
//         ns.setActivity("Rugby");
//
//         System.out.println("Normal Student Name: " + ns.getName());
//         System.out.println("Normal Student Activity: " + ns.getActivity());
//
//         SpecialStudent ss = (SpecialStudent) new StudentFactory(SpecialStudent.class).getStudentFactory();
//         ss.setName("Paul");
//         ss.setCategory("Special Meals");
//
//         System.out.println("Special Student Name: " + ss.getName());
//         System.out.println("Special Student Category: " + ss.getCategory());
//        
//         PrimaryTeacher pt = (PrimaryTeacher) new TeacherFactory<>(PrimaryTeacher.class).getTeacherFactory();
//         pt.setName("Njugus");
//         pt.setEmployeeNo("TP001");
//
//         System.out.println("PT Name: " + pt.getName());
//         System.out.println("PT E No: " + pt.getEmployeeNo());
//        
//         SecondaryTeacher st = (SecondaryTeacher) new TeacherFactory<>(SecondaryTeacher.class).getTeacherFactory();
//         st.setName("Mwanza");
//         st.setEmployeeNo("ST001");
//
//         System.out.println("ST Name: " + st.getName());
//         System.out.println("ST E No: " + st.getEmployeeNo());
//         */
//
//        StakeHolderFactory shf = new StakeHolderFactory("SF", "NS");
//        AbstractFactory af = shf.getAbstractFactory();
//
//        NormalStudent ns = (NormalStudent) af.getPartner();
//        ns.setActivity("Football");
//        System.out.println("Activity: " + ns.getActivity());
//    }

}
