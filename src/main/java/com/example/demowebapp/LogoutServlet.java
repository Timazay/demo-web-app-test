package com.example.demowebapp;

import com.example.demowebapp.model.User;
import com.example.demowebapp.utils.ServletUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LogoutServlet", value = "/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (request.getSession().getAttribute("user") != null){
            session.invalidate();
            System.out.println("Session with id " + session.getId() + " has been invalidated");
            ServletUtils.forwardJSP("blog", request, response);
            return;
        } else {
            ServletUtils.forwardJSP("login", request, response);
            return;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
