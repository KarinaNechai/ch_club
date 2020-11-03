package com.charakhovich.club.web.filter;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter( urlPatterns = "/*")
public class EncodingFilter implements Filter {
    private static final Logger logger = LogManager.getLogger(EncodingFilter.class);
    @Override
    public void init(FilterConfig config) {
        logger.log(Level.INFO,"Filter init() start");
        ServletContext context = config.getServletContext();
        FilterRegistration registration1 = context.getFilterRegistration("FilterSavePage");
        registration1.addMappingForServletNames(null, true, "/controller");
        registration1.addMappingForUrlPatterns(null, true, "/*");
        FilterRegistration registration2 = context.getFilterRegistration("FilterAuthAdmin");
        registration2.addMappingForServletNames(null, true, "/controller");
        registration2.addMappingForUrlPatterns(null, true, "/admin/*");
    }

    @Override
    public void doFilter(ServletRequest rq, ServletResponse rs, FilterChain filterChain) throws IOException, ServletException {
        logger.log(Level.INFO,"EncodingFilter start set UTF8");
        rq.setCharacterEncoding("UTF8");
        rs.setCharacterEncoding("UTF8");
         filterChain.doFilter(rq, rs);
    }
}
