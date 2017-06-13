/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agunga.psls.controller;

import com.agunga.psls.Util.MyUtility;
import com.agunga.psls.beanI.CustomerBeanI;
import com.agunga.psls.beanI.PurchaseBeanI;
import com.agunga.psls.model.Customer;
import com.agunga.psls.model.Purchase;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author agunga
 */
@WebServlet(name = "RedeemPoints", urlPatterns = {"/redeemPoints"})
public class RedeemPoints extends HttpServlet {

    @EJB
    CustomerBeanI customerBeanI;

    @EJB
    PurchaseBeanI pointBeanI;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Customer customer = customerBeanI.retrieve(MyUtility.parseLong(request.getParameter("id")));
        customer.setLitresPurchased(MyUtility.parseDouble(request.getParameter("litresPurchased")));
        customer.setTransactionTime(LocalDateTime.now());

        Purchase p = new Purchase();
        p.setVehicleRegNo(customer.getId());
        p.setNumberOfPoints(MyUtility.parseLong(request.getParameter("litresPurchased")));
        p.setTimeAddedOrRedeemed(LocalDateTime.now());

        if (customerBeanI.add(customer) != null && pointBeanI.add(p) != null) {
            out.print("Added");
        } else {
            out.print("Failed");
        }
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RegisterCustomer</title>");
            out.println("</head>");
            out.println("<body>");

            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
