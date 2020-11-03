package com.charakhovich.club.web.command.impl;

import com.charakhovich.club.model.entity.EntityStatus;
import com.charakhovich.club.model.entity.Event;
import com.charakhovich.club.model.entity.EventType;
import com.charakhovich.club.model.exeption.ServiceException;
import com.charakhovich.club.model.service.EventService;
import com.charakhovich.club.model.service.impl.EventServiceImpl;
import com.charakhovich.club.web.command.*;
import com.charakhovich.club.web.validation.DataValidate;

import javax.servlet.http.HttpServletRequest;

public class EventAddCommand implements Command {
    private static EventService eventService = new EventServiceImpl();
    @Override
    public Router execute(HttpServletRequest req) throws ServiceException {
        RequestContext requestContext=new RequestContext(req);
  /*      Boolean isValid=DataValidate.isValidPageParameters(requestContext);
        if (!isValid){
            req.setAttribute(PageAttribute.MAP_PAGE_PARAMETERS,requestContext.getReqParams());
            return new Router(PagePath.EVENT_ADD,Router.Type.FORWARD);
        }
        Event event=new Event( EventType.valueOf((String) requestContext.getReqParams().get(PageAttribute.EVENT_TYPE)),
                (String) requestContext.getReqParams().get(PageAttribute.EVENT_NAME),
                (String)requestContext.getReqParams().get(PageAttribute.EVENT_DESCRIPTION),
                (String)requestContext.getReqParams().get(PageAttribute.IMAGE_NAME),
                (Integer)requestContext.getReqParams().get(PageAttribute.EVENT_COUNT_TICKETS),
                EntityStatus.ACTUAL.getStatus());
        boolean isCreate=eventService.create(event);*/
        return new Router(PagePath.EVENT_ADD,Router.Type.FORWARD);
    }
}
