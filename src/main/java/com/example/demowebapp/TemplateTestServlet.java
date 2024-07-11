package com.example.demowebapp;

import com.example.demowebapp.utils.IOUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;

@WebServlet(name = "TemplateTestServlet", value = "/template")
public class TemplateTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        File f = new File("D:\\demo-web-app\\src\\main\\webapp\\index.html");
        String indexContent = IOUtils.read(f);

        if (request.getParameter("user") != null) {
            indexContent = indexContent.replace("${action.link}", "logout");
            indexContent = indexContent.replace("${action.name}", "Logout");
            String user = request.getParameter("user");
            indexContent = indexContent.replace("${action.welcome}", "Welcome");
            indexContent = indexContent.replace("${action.hallo}", "Welcome, dear " + user);
        } else {
            indexContent = indexContent.replace("${action.link}", "login");
            indexContent = indexContent.replace("${action.name}", "Login");
            indexContent = indexContent.replace("${action.welcome}", "Unknown");
            indexContent = indexContent.replace("${action.hallo}", "No user!");
        }
        response.getWriter().println(indexContent);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
