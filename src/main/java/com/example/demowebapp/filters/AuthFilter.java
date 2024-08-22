package com.example.demowebapp.filters;

import com.example.demowebapp.model.Role;
import com.example.demowebapp.model.User;
import com.example.demowebapp.utils.ServletUtils;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@WebFilter(filterName = "AuthFilter", urlPatterns = {"/*"})
public class AuthFilter implements Filter {
    private Map<Role, List<String>> authMap;

    private List<String> whiteList;

    public void init(FilterConfig config) throws ServletException {
        Role admin = new Role(1, "ADMIN", null);
        Role manager = new Role(2, "MANAGER", null);
        Role generalUser = new Role(3, "GENERAL_USER", null);

        authMap.put(admin, Arrays.asList("/show-cars", "/blog"));
        authMap.put(manager, Arrays.asList("/show-cars"));
        authMap.put(admin, Arrays.asList("/blog"));

        whiteList = Arrays.asList("/login", "/reg", "/basic-msg");

    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String path = httpRequest.getServletPath();
        User user = ServletUtils.getUserInSession(httpRequest);
        if (whiteList.contains(path)) {
            System.out.println(path + " in white List");
            chain.doFilter(request, response);
            return;
        } else {
            System.out.println(path + " not in white list");
        }
        if (httpRequest.getSession() != null && authMap.containsKey(user.getRole().getId())
                && authMap.containsValue(user.getRole())){
            
        }
    }
}
