package com.example.demowebapp;

import com.example.demowebapp.utils.ServletUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Arrays;

@WebServlet(name = "CarsServlet", value = "/show-cars")
public class CarsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      //  request.setAttribute("cars", Arrays.asList("BMW", "HONDA", "AUDI", "OPEL"));

        ServletUtils.forwardJSP("cars-table", request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
