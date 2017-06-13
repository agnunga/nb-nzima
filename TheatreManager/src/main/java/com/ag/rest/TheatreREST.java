/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.rest;

import com.ag.beanI.TheatreBeanI;
import com.ag.model.ResponseObject;
import com.ag.model.Theatre;
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
@Path("/theatre")
public class TheatreREST {

    @EJB
    TheatreBeanI beanI;

    private ResponseObject responseObject = null;

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Theatre entity) {
        if (beanI.add(entity) != null) {
            responseObject = RestUtil.setResponseObject(true, entity);
        } else {
            responseObject = RestUtil.setResponseObject(false, entity);
        }
        return Response.status(Response.Status.OK).entity(responseObject).build();
    }

    @PUT
    @Path("/update/{id}")
    @Consumes({"application/xml", "application/json"})
    public Response update(@PathParam("id") long id, Theatre entity) {
        entity.setId(id);
        if (beanI.update(entity) != null) {
            responseObject = RestUtil.setResponseObject(true, entity);
        } else {
            responseObject = RestUtil.setResponseObject(false, entity);
        }
        return Response.status(Response.Status.OK).entity(responseObject).build();

    }

    @DELETE
    @Path("/remove/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response remove(@PathParam("id") long id) {
        if (beanI.delete(beanI.findById(id))) {
            responseObject = RestUtil.setResponseObject(true, null);
        } else {
            responseObject = RestUtil.setResponseObject(false, null);
        }
        return Response.status(Response.Status.OK).entity(responseObject).build();
    }

    @GET
    @Path("/find/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response find(@PathParam("id") long id) {
        if (beanI.findById(id) != null) {
            responseObject = RestUtil.setResponseObject(true, beanI.findById(id));
        } else {
            responseObject = RestUtil.setResponseObject(false, null);
        }
        return Response.status(Response.Status.OK).entity(responseObject).build();
    }

    @GET
    @Path("/findAll")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        responseObject = RestUtil.setResponseObject(true, beanI.findAll());
        return Response.status(Response.Status.OK).entity(responseObject).build();
    }
}
