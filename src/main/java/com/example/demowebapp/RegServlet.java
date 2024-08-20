package com.example.demowebapp;

import com.example.demowebapp.model.User;
import com.example.demowebapp.utils.EncryptDecryptUtils;
import com.example.demowebapp.utils.MailUtils;
import com.example.demowebapp.utils.ServletUtils;
import com.example.demowebapp.utils.UserDAOImpl;
import com.mysql.cj.Session;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

@WebServlet(name = "RegServlet", value = "/reg")
public class RegServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Registration page request " + new Date());
        ServletUtils.forwardJSP("reg", request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String name = request.getParameter("name");
        final String email = request.getParameter("email");
        final String pwd = request.getParameter("psw");
        final String rpwd = request.getParameter("rpsw");

        User user = new User();
        if (pwd.equals(rpwd)) {
            user.setName(name);
            user.setEmail(email);
            user.setPassword(pwd);

            UserDAOImpl dao = new UserDAOImpl();

            try {
                boolean isCreated = dao.createUser(user);

                if (isCreated) {
                    // just created - not active
                    // send msg with instructios

                    String subject ="Welcome to Crazy User App";
                    String token = EncryptDecryptUtils.encrypt(user.getEmail());
                    System.out.println(token);
                    String msg = String.format("<b> To confirm your account, " +
                            "please <a href='http://localhost:8080/web_app/activate?token=%s'>click</a></b>", token);


                    MailUtils.sendHtmlMail(user.getEmail(), subject, msg, null, null);

                    request.setAttribute("msg", "Check your email to confirm registration");
                    ServletUtils.forwardJSP("reg", request, response);
               //     ServletUtils.forwardJSP("blog", request, response);
                    return;
                } else {
                    request.setAttribute("msg", "Error user registration");
                }
            } catch (Exception e) {
                e.printStackTrace();
                request.setAttribute("msg", "Internal error User registration");
                String message = ExceptionUtils.getMessage(e.getCause());
                String stackTrace = ExceptionUtils.getStackTrace(e);
                request.setAttribute("cause", StringUtils.isEmpty(message)
                        ? ExceptionUtils.getMessage(e) : message);
                request.setAttribute("stack-trace", stackTrace);
                ServletUtils.forwardJSP("reg", request, response);
                return;
            }

        } else {
            response.getWriter().println("Password mismatch");
            return;
        }
    }
}
