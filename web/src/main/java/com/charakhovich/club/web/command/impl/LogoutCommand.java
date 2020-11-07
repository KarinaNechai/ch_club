package com.charakhovich.club.web.command.impl;

import com.charakhovich.club.web.command.Command;
import com.charakhovich.club.web.command.PagePath;
import com.charakhovich.club.web.command.Router;

import javax.servlet.http.HttpServletRequest;

public class LogoutCommand implements Command {
    @Override
    public Router execute(HttpServletRequest req) {
        req.getSession().invalidate();
        return new Router(PagePath.MAIN,Router.Type.REDIRECT);
    }
}


