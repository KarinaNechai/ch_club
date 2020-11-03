package com.charakhovich.club.web.command.impl;

import com.charakhovich.club.model.exeption.ServiceException;
import com.charakhovich.club.web.command.Command;
import com.charakhovich.club.web.command.Router;

import javax.servlet.http.HttpServletRequest;

public class RegistryCommand implements Command {
    @Override
    public Router execute(HttpServletRequest req) throws ServiceException {
        return null;
    }
}
