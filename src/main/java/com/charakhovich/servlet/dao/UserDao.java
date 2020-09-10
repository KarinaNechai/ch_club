package com.charakhovich.servlet.dao;

import com.charakhovich.servlet.entity.User;

public interface UserDao extends BaseDao <Long, User> {
    public boolean checkLogin(String login, String password) throws DaoException;
}
