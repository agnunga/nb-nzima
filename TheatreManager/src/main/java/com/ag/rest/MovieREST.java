/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.rest;

import com.ag.beanI.MovieBeanI;
import com.ag.model.Movie;
import com.ag.model.ResponseObject;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author agunga
 */
@Path("/movie")
public class MovieREST {

    @EJB
    MovieBeanI beanI;

    private ResponseObject responseObject = null;

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Movie entity) {
        Movie addedMovie = beanI.add(entity);
        if (addedMovie != null) {
            responseObject = RestUtil.setResponseObject(true, addedMovie);
        } else {
            responseObject = RestUtil.setResponseObject(false, entity);
        }
        return Response.status(Response.Status.OK).entity(responseObject).build();
    }

    @PUT
    @Path("/update/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") long id, Movie entity) {
        Movie updatedMovie = beanI.update(id, entity);
        if (updatedMovie != null) {
            responseObject = RestUtil.setResponseObject(true, updatedMovie);
        } else {
            responseObject = RestUtil.setResponseObject(false, entity);
        }
        return Response.status(Response.Status.OK).entity(responseObject).build();

    }

    @PUT
    @Path("/edit")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(Movie entity) {
        Movie updatedMovie = beanI.update(entity);
        if (updatedMovie != null) {
            responseObject = RestUtil.setResponseObject(true, updatedMovie);
        } else {
            responseObject = RestUtil.setResponseObject(false, entity);
        }
        return Response.status(Response.Status.OK).entity(responseObject).build();

    }

    @DELETE
    @Path("/remove/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response remove(@PathParam("id") long id) {
        int deletedRows = beanI.delete(id);
        if (deletedRows > 0) {
            responseObject = RestUtil.setResponseObject(true, deletedRows);
        } else {
            responseObject = RestUtil.setResponseObject(false, deletedRows);
        }
        return Response.status(Response.Status.OK).entity(responseObject).build();
    }

    @GET
    @Path("/find/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response find(@PathParam("id") long id) {
        Movie fetchedMovie = beanI.findById(id);
        if (fetchedMovie != null) {
            responseObject = RestUtil.setResponseObject(true, fetchedMovie);
        } else {
            responseObject = RestUtil.setResponseObject(false, null);
        }
        return Response.status(Response.Status.OK).entity(responseObject).build();
    }

    @GET
    @Path("/findAll")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        responseObject = RestUtil.setResponseObject(true, beanI.findAll());
        return Response.status(Response.Status.OK).entity(responseObject).build();
    }
}
