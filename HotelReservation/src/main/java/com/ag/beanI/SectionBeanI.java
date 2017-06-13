/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.beanI;

import com.ag.model.Section;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author agunga
 */
@Local
public interface SectionBeanI {

    /**
     *
     * @param o
     * @return
     */
    Section add(Section o);

    /**
     *
     * @param o
     * @return
     */
    Section update(Section o);

    /**
     *
     * @return
     */
    List<Section> findAll();

    /**
     *
     * @param o
     * @return
     */
    Section findById(long o);

    /**
     *
     * @param id
     * @return
     */
    boolean delete(Section id);
}
