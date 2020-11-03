package com.charakhovich.club.web.command.impl;

import com.charakhovich.club.web.command.Command;
import com.charakhovich.club.web.command.PagePath;
import com.charakhovich.club.web.command.Router;

import javax.servlet.http.HttpServletRequest;

public class EmptyCommand implements Command {
    @Override
    public Router execute(HttpServletRequest req) {
        String page = PagePath.LOGIN;
        return new Router(PagePath.LOGIN,Router.Type.REDIRECT);
    }
}
