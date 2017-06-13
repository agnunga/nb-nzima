/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agunga.beanI;

import java.util.ArrayList;

/**
 *
 * @author agunga
 */
public interface BaseI {

    boolean add(Object o);

    ArrayList<Object> view(String id);

    boolean update(Object o);

    boolean delete(String id);
}
