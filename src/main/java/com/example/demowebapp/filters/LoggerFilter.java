package com.example.demowebapp.filters;

import com.example.demowebapp.model.Role;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.*;

//@WebFilter(filterName = "LoggerFilter", urlPatterns = {"/*"})
public class LoggerFilter implements Filter {
//    private Map<Role, List<String>> authMap;

    public void init(FilterConfig config) throws ServletException {
//        Role admin = new Role(1, "ADMIN", null);
//        Role manager = new Role(2, "MANAGER", null);
//        Role generalUser = new Role(3, "GENERAL_USER", null);
//
//        authMap.put(admin, Arrays.asList("/show-cars", "/blog"));
//        authMap.put(manager, Arrays.asList("/show-cars"));
//        authMap.put(admin, Arrays.asList("/blog"));

    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        System.out.println(new Date() + "-> Requested: " + httpServletRequest.getServletContext()
                + "/" + httpServletRequest.getServerName()
                + "/" + httpServletRequest.getServerPort());
        System.out.println(new Date() + "-> Requested: " + ((HttpServletRequest) request).getServletPath()
                + "/" + ((HttpServletRequest) request).getRequestedSessionId());
//        chain.doFilter(request, response);
    }
}
