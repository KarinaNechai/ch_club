package com.charakhovich.servlet.command.impl;

import com.charakhovich.servlet.command.Command;
import com.charakhovich.servlet.command.PagePath;

import javax.servlet.http.HttpServletRequest;

public class EmptyCommand implements Command {
    @Override
    public String execute(HttpServletRequest req) {
        String page = PagePath.LOGIN;
        return page;
    }
}
