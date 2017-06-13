/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agunga.bean;

import com.agunga.beanI.EmployeeBeanI;
import com.agunga.beanI.PersonBeanI;
import javax.ejb.EJB;

/**
 *
 * @author agunga
 */
public class MyBase {

    @EJB
    EmployeeBeanI ebi;

    @EJB
    PersonBeanI pbi;
}
