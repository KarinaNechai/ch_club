package com.charakhovich.servlet.service;

import com.charakhovich.servlet.dao.DaoException;

public interface UserService {
    public boolean checkLogin (String login,String password) throws DaoException;
}
