package com.charakhovich.club.web.command.impl;

import com.charakhovich.club.model.exeption.ServiceException;
import com.charakhovich.club.web.command.Command;
import com.charakhovich.club.web.command.PageAttribute;
import com.charakhovich.club.web.command.Router;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LocaleCommand implements Command {
    @Override
    public Router execute(HttpServletRequest req) throws ServiceException {
        HttpSession session = req.getSession();
        String locale = String.valueOf(req.getParameter(PageAttribute.LOCALE));
        session.setAttribute(PageAttribute.LOCALE, locale);
        String page = (String) session.getAttribute(PageAttribute.CURRENT_PAGE);
        return new Router(page, Router.Type.FORWARD);
    }
}
