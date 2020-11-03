package com.charakhovich.club.web.command;
import com.charakhovich.club.model.exeption.ServiceException;

import javax.servlet.http.HttpServletRequest;


public interface Command {
    Router execute(HttpServletRequest req) throws ServiceException;
}
