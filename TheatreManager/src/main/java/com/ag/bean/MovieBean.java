/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.bean;

import com.ag.beanI.MovieBeanI;
import com.ag.dao.MovieDao;
import com.ag.model.Movie;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author agunga
 */
@Stateless
public class MovieBean implements MovieBeanI {

    @PersistenceContext(unitName = "TheatreManager")
    EntityManager em;

    private MovieDao dao = null;

    public MovieDao getDao() {
        return this.dao = this.dao == null ? new MovieDao(em) : this.dao;
    }

    @Override
    public Movie add(Movie o) {
        return getDao().save(o);
    }

    @Override
    public Movie update(Movie o) {
        return getDao().merge(o);
    }

    @Override
    public Movie update(long id, Movie o) {
        Movie existingMovie = findById(id);

        //Set the values of the fields of the existing value with non null fields of the passed Movie object 
        existingMovie.setMainCast((o.getMainCast() != null) ? o.getMainCast() : existingMovie.getMainCast());
        existingMovie.setCountry((o.getCountry() != null) ? o.getCountry() : existingMovie.getCountry());
        existingMovie.setGenre((o.getGenre() != null) ? o.getGenre() : existingMovie.getGenre());
        existingMovie.setName((o.getName() != null) ? o.getName() : existingMovie.getName());

        return update(existingMovie);
    }

    @Override
    public List<Movie> findAll() {
        return getDao().findAll();
    }

    @Override
    public Movie findById(long id) {
        return getDao().findById(id);
    }

    @Override
    public boolean delete(Movie o) {
        return getDao().remove(o);
    }

    @Override
    public int delete(long id) {
        return this.em.createQuery("DELETE FROM Movie m WHERE m.id = :id").setParameter("id", id).executeUpdate();
    }

}
