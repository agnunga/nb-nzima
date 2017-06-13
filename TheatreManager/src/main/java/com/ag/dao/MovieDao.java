/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.dao;

import com.ag.model.Movie;
import javax.persistence.EntityManager;

/**
 *
 * @author agunga
 */
public class MovieDao extends GenericDao<Movie, Long> {

    public MovieDao(EntityManager entityManager) {
        super(Movie.class, entityManager);
    }

}
