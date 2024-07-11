package com.example.demowebapp.utils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class ServletUtils {

    public static void forward(final String path, final HttpServletRequest request,
                               final HttpServletResponse response) throws ServletException, IOException {
        System.out.println(new Date() + ". Forward to : " + path);
        request.getRequestDispatcher("/html/" + path + ".html").forward(request, response);

    }
    public static void forwardJSP(final String path, final HttpServletRequest request,
                               final HttpServletResponse response) throws ServletException, IOException {
        System.out.println(new Date() + ". Forward to JSP : " + path);
        request.getRequestDispatcher("/" + path + ".jsp").forward(request, response);

    }


    public static void include(final String path, final String msg, final HttpServletRequest request,
                               final HttpServletResponse response) throws ServletException, IOException {
        System.out.println(new Date() + ". Include for : " + path);
        response.getWriter().println("<h3>" + msg + "</h3>");
        RequestDispatcher rd =  request.getRequestDispatcher("/html/" + path + ".html");
        rd.include(request, response);
    }

    public static void redirect(final String path, final HttpServletResponse response) throws IOException {
        System.out.println(new Date() + ". Redirect to : " + "/html/" + path + ".html");
        response.sendRedirect("/html/" + path + ".html");
    }

    public static long getLongParameter(final HttpServletRequest request, final String paramName){
        return Long.parseLong(request.getParameter(paramName));
    }

}
