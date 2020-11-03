package com.charakhovich.club.model.dao;

import com.charakhovich.club.model.entity.Entity;
import com.charakhovich.club.model.exeption.DaoException;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public abstract class AbstractDao < T extends Entity> {
    protected Connection connection;
    public abstract List<T> findAll() throws DaoException;
    public abstract T findEntityById(long id) throws DaoException;
    public abstract boolean delete(T entity) ;
    public abstract boolean delete(long id) ;
    public abstract boolean create(T entity) throws DaoException;
    public abstract T update(T entity) ;
    public void close(Statement statement) {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            // log
        }
    }
    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}

