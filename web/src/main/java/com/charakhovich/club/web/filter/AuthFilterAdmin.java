package com.charakhovich.club.web.filter;

import com.charakhovich.club.model.entity.Role;
import com.charakhovich.club.model.entity.User;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "FilterAuthAdmin",
        urlPatterns = "/admin/*")

public class AuthFilterAdmin implements Filter {
    private static final Logger logger = LogManager.getLogger(AuthFilterAdmin.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        User authUser = (User) request.getSession().getAttribute("authUser");
        if (authUser == null) {
            logger.log(Level.WARN,"User not login");
            response.sendRedirect("login.jsp");
            return;
        }
        if (authUser.getRole() != Role.ADMIN) {
            logger.log(Level.WARN,authUser.getLogin() + "doesn't work in module ADMIN");
            response.sendRedirect("login.jsp");
            return;
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
