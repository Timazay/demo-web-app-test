package com.example.demowebapp;

import com.example.demowebapp.model.User;
import com.example.demowebapp.utils.EncryptDecryptUtils;
import com.example.demowebapp.utils.ServletUtils;
import com.example.demowebapp.dao.UserDAOImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ActivateServlet", value = "/activate")
public class ActivateServlet extends HttpServlet {
    private UserDAOImpl dao = new UserDAOImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String token = request.getParameter("token");
        if (token != null){
            // escape chars
            // '+' -> ' '
            token = token.replaceAll(" ", "+");

            String email = EncryptDecryptUtils.decrypt(token);
            User user = dao.findUserByEmail(email);

            if (user != null){
                boolean isActivated = dao.activate(user);

                if (isActivated){
                    request.setAttribute("msg", "Welcome! Activated");
                    ServletUtils.forwardJSP("blog", request, response);
                    return;
                }
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
