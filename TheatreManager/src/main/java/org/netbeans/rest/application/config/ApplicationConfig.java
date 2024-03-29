/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.netbeans.rest.application.config;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author agunga
 */
@javax.ws.rs.ApplicationPath("wr")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<Class<?>>();
        addRestResourceClasses(resources);
        return resources;
    }

    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.ag.rest.MovieREST.class);
        resources.add(com.ag.rest.PriceREST.class);
        resources.add(com.ag.rest.TheatreREST.class);
        resources.add(com.ag.rest.TicketREST.class);
        resources.add(com.ag.rest.UserREST.class);
    }

}
