package com.example.demowebapp;

import com.example.demowebapp.model.User;
import com.example.demowebapp.utils.ServletUtils;
import com.mysql.cj.Session;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Arrays;

@WebServlet(name = "CarsServlet", value = "/show-cars")
public class CarsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = ServletUtils.getUserInSession(request);
        if (user == null) {
            request.setAttribute("msg", "you should login first ");
            ServletUtils.forwardJSP("basic-msg", request, response);
            return;
        } else if (user.getRole().getId() != 1){
            request.setAttribute("msg", "you should have Admin role ");
            ServletUtils.forwardJSP("basic-msg", request, response);
            return;
        } else {
            request.setAttribute("cars", Arrays.asList("BMW", "HONDA", "AUDI", "OPEL"));
            ServletUtils.forwardJSP("cars-table", request, response);
            return;
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
