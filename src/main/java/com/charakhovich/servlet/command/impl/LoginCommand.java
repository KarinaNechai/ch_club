package com.charakhovich.servlet.command.impl;

import com.charakhovich.servlet.command.Command;
import com.charakhovich.servlet.command.PagePath;
import com.charakhovich.servlet.dao.DaoException;
import com.charakhovich.servlet.service.UserService;
import com.charakhovich.servlet.service.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;

public class LoginCommand implements Command {
    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";
    private UserService userService = new UserServiceImpl();

    @Override
    public String execute(HttpServletRequest req) throws DaoException {
        String page = null;
        String login = req.getParameter(PARAM_NAME_LOGIN);
        String password = req.getParameter(PARAM_NAME_PASSWORD);
        if (userService.checkLogin(login, password)) {
            req.setAttribute("authUser", login);
            page = PagePath.MAIN;
        } else {
            req.setAttribute("authUser", login);
            page = PagePath.LOGIN;
        }
        return page;
    }
}
