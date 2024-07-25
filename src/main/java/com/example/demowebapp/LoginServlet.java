package com.example.demowebapp;

import com.example.demowebapp.model.User;
import com.example.demowebapp.utils.ServletUtils;
import com.example.demowebapp.utils.UserDAO;
import com.example.demowebapp.utils.UserDAOImpl;
import com.mysql.cj.Session;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    private UserDAO userDAO = new UserDAOImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Login page request " + new Date());
        ServletUtils.forwardJSP("login", request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String email = request.getParameter("email");
        final String pwd = request.getParameter("psw");

        User user = null;
        if ( (user = userDAO.findUserByEmail(email)) != null){
            if (user.getPassword().equals(pwd)){
                if (!user.isActive()){

                    request.setAttribute("msg", "You are not activated, check your mail! Or  ");
                    ServletUtils.forwardJSP("login", request, response);
                }
                HttpSession session = request.getSession();
                session.setMaxInactiveInterval(90);

                // Store User obj within HTTP session
                session.setAttribute("user", user);

                ServletUtils.forwardJSP("blog",request,response);
                return;
            } else {
            //    response.getWriter().println("Bad credentials");
                ServletUtils.forwardJSP("login", request, response);
                return;
            }
        }



    }
}
