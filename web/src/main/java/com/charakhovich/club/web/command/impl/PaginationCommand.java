package com.charakhovich.club.web.command.impl;

import com.charakhovich.club.model.exeption.ServiceException;
import com.charakhovich.club.model.utils.ServiceUtil;
import com.charakhovich.club.web.command.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class PaginationCommand implements Command {
    @Override
    public Router execute(HttpServletRequest req) throws ServiceException {
        HttpSession session = req.getSession();
      //  String page = (String) session.getAttribute(PageAttribute.CURRENT_PAGE);
        int number_page=Integer.parseInt(req.getParameter("page"));
        String command=req.getParameter(PageParam.PARAM_COMMAND);
        req.setAttribute(PageAttribute.PAGINATION_NUMBER_PAGE, number_page);
        req.setAttribute(PageParam.PARAM_COMMAND, command);
        RequestContext requestContext=new RequestContext(req);
        session.setAttribute("requestContext",req);
        //String page = (String) session.getAttribute(PageAttribute.CURRENT_PAGE);
        StringBuilder page=new StringBuilder().append("/controller?command=event_view").append("&").append(PageAttribute.EVENT_VIEW_ID)
                .append("=").append("1").append("&").append(PageAttribute.PAGINATION_NUMBER_PAGE).append("=").append(number_page);
         return new Router( page.toString(),Router.Type.REDIRECT);

    }
}

