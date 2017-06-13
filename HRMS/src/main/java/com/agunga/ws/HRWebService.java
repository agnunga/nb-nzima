/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agunga.ws;

import com.agunga.beanI.HRBeanI;
import com.agunga.model.HR;
import com.agunga.model.ResponseObject;
import javax.ejb.EJB;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 *
 * @author agunga
 */
@Path("/hr")
public class HRWebService {

    @EJB
    HRBeanI hrbi;

    @Path("/add")
    public Response add(HR o) {
        ResponseObject ro = new ResponseObject();
        if (hrbi.add(o)) {
            ro.setStatus(true);
            ro.setMessage("Success");
            ro.setData(o);
        } else {
            ro.setStatus(false);
            ro.setMessage("Failed");
            ro.setData(o);
        }
        return Response.status(Response.Status.OK).entity(ro).build();
    }

    @Path("/view/{param}")
    public Response view(@PathParam("param") String s) {
        ResponseObject ro = new ResponseObject();
        if (hrbi.view(s) != null) {
            ro.setStatus(true);
            ro.setMessage("Success");
            ro.setData(s);
        } else {
            ro.setStatus(false);
            ro.setMessage("Failed");
            ro.setData(s);
        }
        return Response.status(Response.Status.OK).entity(ro).build();
    }

    @Path("/update")
    public Response update(HR o) {
        ResponseObject ro = new ResponseObject();
        if (hrbi.update(o)) {
            ro.setStatus(true);
            ro.setMessage("Success");
            ro.setData(o);
        } else {
            ro.setStatus(false);
            ro.setMessage("Failed");
            ro.setData(o);
        }
        return Response.status(Response.Status.OK).entity(ro).build();
    }

    @Path("/delete")
    public Response delete(String s) {
        ResponseObject ro = new ResponseObject();
        if (hrbi.add(s)) {
            ro.setStatus(true);
            ro.setMessage("Success");
            ro.setData(s);
        } else {
            ro.setStatus(false);
            ro.setMessage("Failed");
            ro.setData(s);
        }
        return Response.status(Response.Status.OK).entity(ro).build();
    }

}
