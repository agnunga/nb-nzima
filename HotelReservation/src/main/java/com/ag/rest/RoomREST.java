/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.rest;

import com.xag.util.RestUtil;
import com.ag.beanI.RoomBeanI;
import com.ag.beanI.ReservationBeanI;
import com.ag.model.Hotel;
import com.ag.model.Room;
import com.ag.model.ResponseObject;
import com.ag.model.Reservation;
import com.ag.model.Section;
import com.xag.util.NoMatchFound; 
import java.util.logging.Level;
import java.util.logging.Logger;
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
@Path("/room")
public class RoomREST {

    @EJB
    RoomBeanI beanI;
    @EJB
    ReservationBeanI rtbi;

    private ResponseObject responseObject = null;

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Room entity) {
        Room addedRoom = beanI.add(entity);
        responseObject = (addedRoom != null) ? RestUtil.setResponseObject(true, addedRoom) : RestUtil.setResponseObject(false, entity);
        return Response.status(Response.Status.OK).entity(responseObject).build();
    }

    @PUT
    @Path("/edit")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(Room entity) {
        Room updatedRoom = beanI.update(entity);
        responseObject = (updatedRoom != null) ? RestUtil.setResponseObject(true, updatedRoom) : RestUtil.setResponseObject(false, entity);
        return Response.status(Response.Status.OK).entity(responseObject).build();
    }

    @DELETE
    @Path("/remove/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response remove(@PathParam("id") long id) {
        int deletedRows = beanI.delete(id);
        responseObject = (deletedRows > 0) ? RestUtil.setResponseObject(true, deletedRows) : RestUtil.setResponseObject(false, deletedRows);
        return Response.status(Response.Status.OK).entity(responseObject).build();
    }

    @GET
    @Path("/find/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response find(@PathParam("id") long id) {
        Room fetchedRoom = null;
        try {
            fetchedRoom = beanI.findById(id);
        } catch (NoMatchFound ex) {
            Logger.getLogger(RoomREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        responseObject = (fetchedRoom != null) ? RestUtil.setResponseObject(true, fetchedRoom) : RestUtil.setResponseObject(false, null);
        return Response.status(Response.Status.OK).entity(responseObject).build();
    }

    @GET
    @Path("/findAll")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        responseObject = RestUtil.setResponseObject(true, beanI.findAll());
        return Response.status(Response.Status.OK).entity(responseObject).build();
    }

    @POST
    @Path("/getOccupiedRooms")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOccupiedRooms(Hotel h, Section s) {
        return Response.status(Response.Status.OK).entity(RestUtil.setResponseObject(true, beanI.getOccupiedRooms(h, s))).build();
    }

    @POST
    @Path("/getUnoccupiedRooms")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUnoccupiedRooms(Hotel h, Section s) {
        return Response.status(Response.Status.OK).entity(RestUtil.setResponseObject(true, beanI.getUnoccupiedRooms(h, s))).build();
    }

    @POST
    @Path("/checkIn/{param}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response checkIn(@PathParam("param") long id) {
        responseObject = beanI.checkIn(id) ? RestUtil.setResponseObject(true, true) : RestUtil.setResponseObject(false, false);
        return Response.status(Response.Status.OK).entity(responseObject).build();
    }

    @POST
    @Path("/checkOut/{param}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response checkOut(@PathParam("param") long id) {
        responseObject = beanI.checkOut(id) ? RestUtil.setResponseObject(true, true) : RestUtil.setResponseObject(false, false);
        return Response.status(Response.Status.OK).entity(responseObject).build();
    }

    @POST
    @Path("/bookRoom")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response bookRoom(Reservation r) {
        Reservation reservation = beanI.bookRoom(r);
        responseObject = (reservation != null) ? RestUtil.setResponseObject(true, reservation) : RestUtil.setResponseObject(false, r);
        return Response.status(Response.Status.OK).entity(responseObject).build();
    }

    @POST
    @Path("/isRoomAvailable")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response isRoomAvailable(Reservation r) {
        responseObject = (beanI.isRoomAvailable(r)) ? RestUtil.setResponseObject(true, r) : RestUtil.setResponseObject(false, r);
        return Response.status(Response.Status.OK).entity(responseObject).build();
    }
}
