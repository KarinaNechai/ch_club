package com.charakhovich.club.web.command.impl;

import com.charakhovich.club.model.entity.User;
import com.charakhovich.club.model.exeption.ServiceException;
import com.charakhovich.club.model.service.UserService;
import com.charakhovich.club.model.service.impl.UserServiceImpl;
import com.charakhovich.club.model.utils.ServiceUtil;
import com.charakhovich.club.web.command.Command;
import com.charakhovich.club.web.command.PageAttribute;
import com.charakhovich.club.web.command.PagePath;
import com.charakhovich.club.web.command.Router;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginCommand implements Command {
    private static UserService userService = new UserServiceImpl();

    @Override
    public Router execute(HttpServletRequest req) throws ServiceException {
        HttpSession session=req.getSession();
        String login = req.getParameter(PageAttribute.USER_LOGIN);
        String password = req.getParameter(PageAttribute.USER_PASSWORD);
        String hashPassword= ServiceUtil.md5Apache(password);
        Router router;
        if (userService.checkLogin(login, hashPassword)) {
            User authUser=userService.findUserByLogin(login);
            session.setAttribute(PageAttribute.AUTH_USER, authUser);
            router=new Router(PagePath.MAIN,Router.Type.FORWARD);
        } else {
            session.invalidate();
            router=new Router(PagePath.LOGIN,Router.Type.REDIRECT);
        }
        return router;
    }
}
