package com.charakhovich.servlet.command.impl;

import com.charakhovich.servlet.command.Command;
import com.charakhovich.servlet.command.PagePath;

import javax.servlet.http.HttpServletRequest;

public class LogoutCommand implements Command {
    @Override
    public String execute(HttpServletRequest req) {
        String page = PagePath.LOGIN;
        req.getSession().invalidate();
        req.setAttribute("authUser", null);
            page = PagePath.LOGIN;
            return page;
        }
    }


