package com.charakhovich.club.web.command.impl;

import com.charakhovich.club.model.entity.Event;
import com.charakhovich.club.model.exeption.ServiceException;
import com.charakhovich.club.model.service.EventService;
import com.charakhovich.club.model.service.impl.EventServiceImpl;
import com.charakhovich.club.web.command.Command;
import com.charakhovich.club.web.command.PageAttribute;
import com.charakhovich.club.web.command.PagePath;
import com.charakhovich.club.web.command.Router;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class EventViewCommand implements Command {
    private static final EventService eventService = new EventServiceImpl();
    @Override
    public Router execute(HttpServletRequest req) throws ServiceException {
        HttpSession session=req.getSession();
        long eventId = Long.parseLong(req.getParameter(PageAttribute.EVENT_VIEW_ID));
        Event event=eventService.findEntityById(eventId);
        session.setAttribute(PageAttribute.EVENT_VIEW, event);
        String page= (String) session.getAttribute(PageAttribute.CURRENT_PAGE);
        return new Router(PagePath.EVENT_VIEW,Router.Type.FORWARD);
    }
}
