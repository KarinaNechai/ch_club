package com.charakhovich.club.web.command.impl;

import com.charakhovich.club.model.entity.Event;
import com.charakhovich.club.model.entity.MessageEvent;
import com.charakhovich.club.model.entity.Page;
import com.charakhovich.club.model.exeption.ServiceException;
import com.charakhovich.club.model.service.EventService;
import com.charakhovich.club.model.service.MessageEventService;
import com.charakhovich.club.model.service.impl.EventServiceImpl;
import com.charakhovich.club.model.service.impl.MessageEventServiceImpl;
import com.charakhovich.club.web.command.Command;
import com.charakhovich.club.web.command.PageAttribute;
import com.charakhovich.club.web.command.PagePath;
import com.charakhovich.club.web.command.Router;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

public class EventViewCommand implements Command {
    private static final EventService eventService = new EventServiceImpl();
    private static final MessageEventService messageEventService = new MessageEventServiceImpl();

    @Override
    public Router execute(HttpServletRequest req) {
        try {
            long eventId = Long.parseLong(req.getParameter(PageAttribute.EVENT_VIEW_ID));
            Event event = null;
            event = eventService.findEntityById(eventId);
            int countOfMessages = messageEventService.countOfMessages(eventId);
            int countPages = (int) Math.ceil(countOfMessages * 1.0 / Page.RECORD_NUMBER);
            String str= Optional.ofNullable(req.getParameter(PageAttribute.PAGINATION_NUMBER_PAGE)).orElse("1");
            int numberPage =Integer.parseInt(str);
            List<MessageEvent> listMessageEvent = messageEventService.findMessagesEvent(eventId, new Page(numberPage));
            req.setAttribute(PageAttribute.EVENT_VIEW, event);
            req.setAttribute(PageAttribute.EVENT_MESSAGES, listMessageEvent);
            req.setAttribute(PageAttribute.PAGINATION_NUMBER_PAGE, numberPage);
            req.setAttribute(PageAttribute.PAGINATION_COUNT_PAGES, countPages);
            return new Router(PagePath.EVENT_VIEW, Router.Type.FORWARD);
        } catch (ServiceException e) {
            e.printStackTrace();
            return new Router(PagePath.ERROR_500, Router.Type.REDIRECT);
        } finally {

        }

    }
}
