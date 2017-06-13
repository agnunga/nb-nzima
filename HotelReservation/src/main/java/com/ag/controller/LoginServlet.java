package com.ag.controller;

import com.ag.beanI.UserBeanI;
import com.ag.model.User;
import com.xag.util.MailObject;
import com.xag.util.SendMailTLS;
import java.io.IOException;
import javax.ejb.EJB;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/start")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @EJB
    UserBeanI ubi;

    MailObject mo = null;

    private MailObject getMailObject() {
        return (this.mo == null) ? new MailObject() : mo;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = ubi.authenticate(username, password);

        HttpSession session = request.getSession();
        if (user != null) {
            session.setAttribute("usersession", user.getId());
            response.sendRedirect("u");
        } else {
//            MailObject mo1 = new MailObject();
            MailObject mo1 = getMailObject();
            mo1.setTo(username);
            mo1.setMessageSubject("Login Attempt");
            mo1.setMessageBody("Was this you?");
            request.setAttribute("message", SendMailTLS.sendMail(mo1)
                    ? "Invalid Credentials. Try again or check your email for additional information!"
                    : "Invalid Credentials. Try again"
            );
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }
}
