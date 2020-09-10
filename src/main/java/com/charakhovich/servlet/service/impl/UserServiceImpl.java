package com.charakhovich.servlet.service.impl;

import com.charakhovich.servlet.dao.DaoException;
import com.charakhovich.servlet.dao.UserDao;
import com.charakhovich.servlet.dao.impl.UserDaoImpl;
import com.charakhovich.servlet.pool.ConnectionPool;
import com.charakhovich.servlet.service.UserService;

import java.sql.Connection;

public class UserServiceImpl implements UserService {
    private static final String ADMIN_LOGIN="admin";
    private static final String ADMIN_PASSWORD="1111";
    private ConnectionPool connectionPool=ConnectionPool.getInstance();
    static final UserDao userDao=new UserDaoImpl();
    @Override
    public boolean checkLogin(String login, String password) throws DaoException {

        return userDao.checkLogin(login,password);
        //return ADMIN_LOGIN.equals(login)&&ADMIN_PASSWORD.equals(password);
    }
}
