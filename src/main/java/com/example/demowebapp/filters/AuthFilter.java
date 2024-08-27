package com.example.demowebapp.filters;

import com.example.demowebapp.model.Role;
import com.example.demowebapp.model.User;
import com.example.demowebapp.utils.ServletUtils;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebFilter(filterName = "AuthFilter", urlPatterns = {"/*"})
public class AuthFilter implements Filter {
    private Map<Role, List<String>> authMap = new HashMap<>();

    private List<String> whiteList = new ArrayList<>();

    public void init(FilterConfig config) throws ServletException {
        Role admin = new Role(1, "ADMIN", null);
        Role manager = new Role(2, "MANAGER", null);
        Role generalUser = new Role(3, "GENERAL_USER", null);

        authMap.put(admin, Arrays.asList("/show-cars", "/hello-servlet", "/blog"));
        authMap.put(manager, Arrays.asList("/hello-servlet", "/blog"));
        authMap.put(generalUser, Arrays.asList("/blog"));

        whiteList = Arrays.asList("/login", "/reg", "/basic-msg");

    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        String path = httpRequest.getServletPath();
        User user = ServletUtils.getUserInSession(httpRequest);

        if (whiteList.contains(path)) {
            System.out.println(path + " in white List");
            chain.doFilter(request, response);
            return;
        } else {
            System.out.println(path + " not in white list");
        }
        if (user != null && authMap.containsKey(user.getRole())) {
            List<String> allowedPaths = authMap.get(user.getRole());
            if (allowedPaths.contains(path)) {
                System.out.println(path + " access granted for role: " + user.getRole().getName());
                chain.doFilter(request, response);
            } else {
                System.out.println(path + " access denied for role: " + user.getRole().getName());
            }
        } else {
            System.out.println("User is not authenticated or role not found.");
        }
    }
}
