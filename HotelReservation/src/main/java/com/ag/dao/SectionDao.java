/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.dao;

import com.ag.model.Section;
import javax.persistence.EntityManager;

/**
 *
 * @author agunga
 */
public class SectionDao extends GenericDao<Section, Long> {

    public SectionDao(EntityManager entityManager) {
        super(Section.class, entityManager);
    }

}
