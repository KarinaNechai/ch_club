package com.charakhovich.club.model.dao.impl;

import com.charakhovich.club.model.dao.AbstractDao;
import com.charakhovich.club.model.dao.TableColumnName;
import com.charakhovich.club.model.dao.UserDao;
import com.charakhovich.club.model.entity.User;
import com.charakhovich.club.model.exeption.DaoException;
import com.charakhovich.club.model.entity.Role;
import com.charakhovich.club.model.entity.Page;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl extends AbstractDao<User> implements UserDao {
    private static final String SELECT_LOGIN_PASSWORD =
            "SELECT userid, login, password FROM ch_user where login=?";
    private static final String SELECT_USER_BY_LOGIN =
            "SELECT userid, login,firstname,lastname,role, actfl FROM ch_user where actfl=? and login=? ";
    private static final String INSERT_USER = "INSERT INTO ch_user (login, email, userpassword," +
            " usersurname, userfirstname,userphone,userrole) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?)";

    @Override
    public User findUserByLogin(String login) throws DaoException {
        User user = null;
        Connection connection = this.connection;
        PreparedStatement statement = null;
        String tempPassword = null;
        try {
            statement = connection.prepareStatement(SELECT_USER_BY_LOGIN);
            statement.setString(1, "1");
            statement.setString(2, login);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt(TableColumnName.USER_DAO_ID));
                user.setLogin(resultSet.getString(TableColumnName.USER_DAO_LOGIN));
                user.setFirstName(resultSet.getString(TableColumnName.USER_DAO_FIRSTNAME));
                user.setFirstName(resultSet.getString(TableColumnName.USER_DAO_LASTNAME));
                user.setRole(Role.valueOf(resultSet.getString(TableColumnName.USER_DAO_ROLE)));
                user.setActual(resultSet.getBoolean(TableColumnName.EVENT_DAO_ACTFL));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
        }
        return user;
    }

    @Override
    public boolean checkLogin(String login, String password) throws DaoException {
        User user = null;
        Connection connection = this.connection;
        PreparedStatement statement = null;
        String tempPassword = null;
        try {
            statement = connection.prepareStatement(SELECT_LOGIN_PASSWORD);
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt(TableColumnName.USER_DAO_ID));
                user.setLogin(resultSet.getString(TableColumnName.USER_DAO_LOGIN));
                tempPassword = resultSet.getString(TableColumnName.USER_DAO_PASSWORD);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
        }
        boolean flag = user != null ? user.getLogin().equals(login) && tempPassword.equals(password) : false;
        return flag;
    }

    @Override
    public int count(Role role) {
        return 0;
    }

    @Override
    public List<User> findByRole(Role role) {
        return null;
    }

    @Override
    public List<User> findByRole(Role role, Page page) {
        return null;
    }


    @Override
    public User login(String login, String password) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findEntityById(long id) {
        return null;
    }

    @Override
    public boolean delete(User entity) {
        return false;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }

    @Override
    public boolean create(User entity) throws DaoException {
        User user = null;
        Connection connection = this.connection;
        PreparedStatement statement = null;
        boolean flag = false;
        try {
            statement = connection.prepareStatement(INSERT_USER);
            statement.setString(1, entity.getLogin() != null ? entity.getLogin() : "");
            statement.setString(2, entity.getEmail() != null ? entity.getEmail() : "");
            statement.setString(3, entity.getPassword() != null ? entity.getPassword() : "");
            statement.setString(4, entity.getLastName() != null ? entity.getLastName() : "");
            statement.setString(5, entity.getFirstName() != null ? entity.getFirstName() : "");
            statement.setString(6, entity.getPhone() != null ? entity.getPhone() : "");
            statement.setString(7, "9");
            if (statement.executeUpdate() == 1) {
                flag = true;
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
        }
        return flag;
    }

    @Override
    public User update(User entity) {
        return null;
    }
}