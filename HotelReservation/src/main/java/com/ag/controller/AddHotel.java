/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.controller;

import com.ag.beanI.HotelBeanI;
import com.ag.model.Hotel;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author agunga
 */
@WebServlet(name = "AddHotel", urlPatterns = {"/u/add_hotel"})
public class AddHotel extends HttpServlet {

    @EJB
    HotelBeanI beanI;

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/addHotel.jsp");
        dispatcher.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Hotel hotel = new Hotel();
        String name = request.getParameter("name");
        String location = request.getParameter("location");
        String particulars = request.getParameter("particulars");
        hotel.setName(name);
        hotel.setLocation(location);
        hotel.setParticulars(particulars);
        Hotel hotel1 = beanI.add(hotel);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/addHotel.jsp");
        request.setAttribute("message", "Success");
        if (hotel1 == null) {
            request.setAttribute("message", "Failed");
        }
        dispatcher.forward(request, response);
    }

}
