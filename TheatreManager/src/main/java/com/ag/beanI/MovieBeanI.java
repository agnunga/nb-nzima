/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.beanI;

import com.ag.model.Movie;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author agunga
 */
@Local
public interface MovieBeanI {

    /**
     * @param o is the object to be updated
     * @return the added Movie
     */
    Movie add(Movie o);

    /**
     *
     * @param o is the object to be updated
     * @return the updated Movie
     */
    Movie update(Movie o);

    /**
     *
     * @param id is the primary key
     * @param o is the object to be updated
     * @return the updated Movie
     */
    Movie update(long id, Movie o);

    /**
     *
     * @author agunga
     * @return a List of Movies
     */
    List<Movie> findAll();

    /**
     *
     * @author agunga
     * @param o is the primaryId
     * @return a Movie object
     */
    Movie findById(long o);

    /**
     *
     * @author agunga
     * @param id is the primaryId
     * @return true if the deletion was successful
     */
    boolean delete(Movie id);

    /**
     *
     * @author agunga
     * @param id is the primaryId
     * @return the number of deleted records
     */
    int delete(long id);
}
