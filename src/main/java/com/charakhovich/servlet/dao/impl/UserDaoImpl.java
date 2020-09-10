package com.charakhovich.servlet.dao.impl;

import com.charakhovich.servlet.pool.ConnectionPool;
import com.charakhovich.servlet.pool.ConnectorCreator;
import com.charakhovich.servlet.dao.DaoException;
import com.charakhovich.servlet.dao.UserDao;
import com.charakhovich.servlet.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private static final String SQL_SELECT_LOGIN_PASSWORD =
            "SELECT id, login, password FROM user where login=?";
    private ConnectionPool connectionPool = ConnectionPool.getInstance();
    @Override
    public boolean checkLogin(String login, String password) throws DaoException {
       User user=null;
       Connection connection=connectionPool.getConnection();
       PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_SELECT_LOGIN_PASSWORD);
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                user=new User();
                user.setId(resultSet.getInt("id"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(statement);
            connectionPool.returnConnection(connection);
        }
        boolean flag=user!=null?user.getLogin().equals(login)&&user.getPassword().equals(password):false;
        return flag;
    }

    @Override
    public List<User> findAll() throws DaoException {
        return null;
    }

    @Override
    public User findEntityById(Long id) throws DaoException {
        return null;
    }

    @Override
    public boolean delete(User user) throws DaoException {
        return false;
    }

    @Override
    public boolean delete(Long id) throws DaoException {
        return false;
    }

    @Override
    public boolean create(User user) throws DaoException {
        return false;
    }

    @Override
    public User update(User user) throws DaoException {
        return null;
    }
}