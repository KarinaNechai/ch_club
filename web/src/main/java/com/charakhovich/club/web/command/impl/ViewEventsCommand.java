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
import java.util.List;

public class ViewEventsCommand implements Command {
    private static final EventService eventService = new EventServiceImpl();

    @Override
    public Router execute(HttpServletRequest req) throws ServiceException {
        List<Event> listEvent=eventService.findAll();
        req.setAttribute(PageAttribute.LIST_EVENT, listEvent);
        String page = PagePath.EVENTS;
        return new Router(PagePath.EVENTS,Router.Type.FORWARD);
    }
}
