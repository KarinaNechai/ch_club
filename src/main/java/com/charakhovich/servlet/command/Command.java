package com.charakhovich.servlet.command;

import com.charakhovich.servlet.dao.DaoException;

import javax.servlet.http.HttpServletRequest;


public interface Command {
    String execute(HttpServletRequest req) throws DaoException;
}
