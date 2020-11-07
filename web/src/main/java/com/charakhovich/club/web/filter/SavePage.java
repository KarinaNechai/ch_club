package com.charakhovich.club.web.filter;

import com.charakhovich.club.web.command.PageAttribute;
import com.charakhovich.club.web.command.PagePath;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebFilter(filterName = "FilterSavePage",
        urlPatterns = {"/do/*"})
public class SavePage implements Filter {
    private static final String REFERER = "referer";
    private static final String PATH_REGEX_START = "/do.+";
    private static final char SPLIT_PARAMS = '?';

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
    /*    HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession(true);
        String url = req.getHeader(REFERER);
        if (url != null) {
            String path = subStringPathWithRegex1(url);
            session.setAttribute(PageAttribute.CURRENT_PAGE, path);
        }*/
           filterChain.doFilter(servletRequest, servletResponse);
        }

    private String subStringPathWithRegex1(String url) {
        Pattern pattern = Pattern.compile(PATH_REGEX_START);
        String path = null;
        if (url != null) {
            Matcher matcher = pattern.matcher(url);
            if (matcher.find()) {
                path = matcher.group(0);
            } else {
                path = PagePath.MAIN;
            }
        }
        return path;
    }

}