package com.charakhovich.club.model.dao.impl;

import com.charakhovich.club.model.dao.AbstractDao;
import com.charakhovich.club.model.dao.MessageEventDao;
import com.charakhovich.club.model.dao.TableColumnName;
import com.charakhovich.club.model.entity.*;
import com.charakhovich.club.model.exeption.DaoException;
import com.charakhovich.club.model.utils.ServiceUtil;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MessageEventDaoImpl extends AbstractDao<MessageEvent> implements MessageEventDao {

    private static final String SELECT_MESSAGES_BY_EVENT =
            "SELECT message_id, user_id, event_id, text, modifydate FROM ch_message where event_id=? ORDER BY modifydate" ;
    private static final String SELECT_MESSAGES_BY_EVENT_LIMIT_PAGE =
            "SELECT message_id, user_id, event_id, text, modifydate FROM ch_message where event_id=? ORDER BY modifydate " +
                    "LIMIT ?,?" ;
    private static final String INSERT_MESSAGE="INSERT INTO ch_message (event_id,user_id, modifydate, text)" +
            " VALUES (?, ?,?,?)";
    @Override
    public List<MessageEvent> findMessagesEvent(long eventId) throws DaoException {
        List<MessageEvent> listMessages= new ArrayList<MessageEvent>();
        Connection connection = this.connection;
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SELECT_MESSAGES_BY_EVENT);
            statement.setString(1,String.valueOf( eventId));
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                MessageEvent messageEvent = new MessageEvent();
                messageEvent.setEventId(resultSet.getLong(TableColumnName.MESSAGE_DAO_EVENT_ID));
                messageEvent.setMessageId(resultSet.getLong(TableColumnName.MESSAGE_DAO_ID));
                messageEvent.setUserId(resultSet.getLong(TableColumnName.MESSAGE_DAO_USER_ID));
                Timestamp t=resultSet.getTimestamp(TableColumnName.MESSAGE_DAO_MODIFY_DATE);
                LocalDateTime localDateTime=t.toLocalDateTime();
                messageEvent.setModifyDate(localDateTime);
                messageEvent.setText(resultSet.getString(TableColumnName.MESSAGE_DAO_TEXT));
                listMessages.add(messageEvent);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {

        }
        return listMessages;

    }

    @Override
    public List<MessageEvent> findMessagesEvent(long eventId, Page page) throws DaoException {
        List<MessageEvent> listMessages= new ArrayList<MessageEvent>();
        Connection connection = this.connection;
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SELECT_MESSAGES_BY_EVENT_LIMIT_PAGE);
            statement.setLong(1,eventId);
            statement.setInt(2,page.getFirst());
            statement.setInt(3,page.getMax());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                MessageEvent messageEvent = new MessageEvent();
                messageEvent.setEventId(resultSet.getLong(TableColumnName.MESSAGE_DAO_EVENT_ID));
                messageEvent.setMessageId(resultSet.getLong(TableColumnName.MESSAGE_DAO_ID));
                messageEvent.setUserId(resultSet.getLong(TableColumnName.MESSAGE_DAO_USER_ID));
                Timestamp t=resultSet.getTimestamp(TableColumnName.MESSAGE_DAO_MODIFY_DATE);
                LocalDateTime localDateTime=t.toLocalDateTime();
                messageEvent.setModifyDate(localDateTime);
                messageEvent.setText(resultSet.getString(TableColumnName.MESSAGE_DAO_TEXT));
                listMessages.add(messageEvent);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {

        }
        return listMessages;

    }
    @Override
    public List findAll() throws DaoException {
        return null;
    }

    @Override
    public MessageEvent findEntityById(long id) throws DaoException {
        return null;
    }

    @Override
    public boolean delete(MessageEvent entity) {
        return false;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }

    @Override
    public boolean create(MessageEvent entity) throws DaoException {
        Connection connection = this.connection;
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(INSERT_MESSAGE);
            statement.setLong(1, entity.getEventId());
            statement.setLong(2, entity.getUserId());
            Timestamp timestamp = Timestamp.valueOf(entity.getModifyDate());
            statement.setTimestamp(3, timestamp);
            statement.setString(4, entity.getText());
            int result = statement.executeUpdate();
            statement.close();
            return result==1?true:false;

        }
        catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public MessageEvent update(MessageEvent entity) {
        return null;
    }




}
