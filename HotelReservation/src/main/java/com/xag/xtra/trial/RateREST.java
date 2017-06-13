///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.xag.xtra.trial;
//
//import com.xag.util.RestUtil;
//import com.xag.xtra.trial.RateBeanI;
//import com.xag.xtra.trial.Rate;
//import com.ag.model.ResponseObject;
//import javax.ejb.EJB;
//import javax.ejb.Stateless;
//import javax.ws.rs.Consumes;
//import javax.ws.rs.DELETE;
//import javax.ws.rs.GET;
//import javax.ws.rs.POST;
//import javax.ws.rs.PUT;
//import javax.ws.rs.Path;
//import javax.ws.rs.PathParam;
//import javax.ws.rs.Produces;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response;
//
///**
// *
// * @author agunga
// */
//@Stateless
//@Path("/rate")
//public class RateREST {
//
//    @EJB
//    RateBeanI beanI;
//
//    private ResponseObject responseObject = null;
//
//    @POST
//    @Path("/add")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response create(Rate entity) {
//        responseObject = (beanI.add(entity) != null) ? RestUtil.setResponseObject(true, entity) : RestUtil.setResponseObject(false, entity);
//        return Response.status(Response.Status.OK).entity(responseObject).build();
//    }
//
//    @PUT
//    @Path("/update/{id}")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response update(@PathParam("id") long id, Rate entity) {
//        entity.setId(id);
//        responseObject = (beanI.update(entity) != null) ? RestUtil.setResponseObject(true, entity) : RestUtil.setResponseObject(false, entity);
//        return Response.status(Response.Status.OK).entity(responseObject).build();
//    }
//
//    @DELETE
//    @Path("/remove/{id}")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response remove(@PathParam("id") long id) {
//        responseObject = (beanI.delete(beanI.findById(id))) ? RestUtil.setResponseObject(true, null) : RestUtil.setResponseObject(false, null);
//        return Response.status(Response.Status.OK).entity(responseObject).build();
//    }
//
//    @GET
//    @Path("/find/{id}")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response find(@PathParam("id") long id) {
//        responseObject = (beanI.findById(id) != null) ? RestUtil.setResponseObject(true, beanI.findById(id)) : RestUtil.setResponseObject(false, null);
//        return Response.status(Response.Status.OK).entity(responseObject).build();
//    }
//
//    @GET
//    @Path("/findAll")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response findAll() {
//        responseObject = RestUtil.setResponseObject(true, beanI.findAll());
//        return Response.status(Response.Status.OK).entity(responseObject).build();
//    }
//}
