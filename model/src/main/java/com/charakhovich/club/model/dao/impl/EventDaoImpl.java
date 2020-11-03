package com.charakhovich.club.model.dao.impl;

import com.charakhovich.club.model.dao.AbstractDao;
import com.charakhovich.club.model.dao.EventDao;
import com.charakhovich.club.model.dao.TableColumnName;
import com.charakhovich.club.model.entity.Event;
import com.charakhovich.club.model.entity.EventType;
import com.charakhovich.club.model.exeption.DaoException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EventDaoImpl extends AbstractDao<Event> implements EventDao {
    private static final Logger Logger= LogManager.getLogger(EventDaoImpl.class);
    private static final String SELECT_ACTUAL_EVENTS =
            "select eventid,typeevent,name,description,picture,counttickets,actflag,modifydate,short_description from ch_event " +
                    "where actflag=? order by modifydate desc";
    private static final String INSERT_EVENT =
                   "INSERT INTO ch_event (typeevent,name,description,picture,counttickets,actflag,modifydate)  VALUES(?,?,?,?,?,?,?)";
    private static final String SELECT_EVENT_BY_ID =
            "select eventid,typeevent,name,description,short_description,actflag from ch_event where eventid=?";

    @Override
    public List<Event> findAll() throws DaoException {
        List<Event> events= new ArrayList<Event>();
        Connection connection = this.connection;
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SELECT_ACTUAL_EVENTS);
            statement.setString(1, "1");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Event event = new Event();
                event.setEventId(resultSet.getInt(TableColumnName.EVENT_DAO_ID));
                event.setEventType(EventType.valueOf(resultSet.getString(TableColumnName.EVENT_DAO_TYPE_EVENT)));
                event.setName(resultSet.getString(TableColumnName.EVENT_DAO_NAME));
                Blob blob=resultSet.getBlob(TableColumnName.EVENT_DAO_DESCRIPTION);
                byte[] bdata = blob.getBytes(1, (int) blob.length());
                String description = new String(bdata);
                event.setDescription(description);
                event.setNamePicture(resultSet.getString(TableColumnName.EVENT_DAO_PICTURE));
                event.setCountTickets(resultSet.getInt(TableColumnName.EVENT_DAO_COUNT_TICKETS));
                Timestamp t=resultSet.getTimestamp(TableColumnName.EVENT_DAO_MODIFY_DATE);
                LocalDateTime localDateTime=t.toLocalDateTime();
                event.setModifyDate(localDateTime);
                event.setShortDescription(resultSet.getString(TableColumnName.EVENT_DAO_SHORT_DESCRIPTION));
               // myJavaSqlDate
              //  LocalDateTime localDate = myJavaSqlDate.toLocalDate();
             /*   SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
                String str= resultSet.getString("modifydate");
                LocalDateTime l=LocalDateTime.parse((CharSequence) str, DateTimeFormatter.ofPattern ("dd.MM.yyyy HH:mm:ss"));
               event.setModifyDate(l);
                */ events.add(event);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
        }
        return events;
    }

    @Override
    public Event findEntityById(long id) throws DaoException {
        Event event = null;
        Connection connection = this.connection;
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SELECT_EVENT_BY_ID);
            statement.setString(1, String.valueOf(id));
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                event=new Event();
                event.setEventId(resultSet.getInt(TableColumnName.EVENT_DAO_ID));
                event.setEventType(EventType.valueOf(resultSet.getString(TableColumnName.EVENT_DAO_TYPE_EVENT)));
                event.setName(resultSet.getString(TableColumnName.EVENT_DAO_NAME));
                Blob blob=resultSet.getBlob(TableColumnName.EVENT_DAO_DESCRIPTION);
                byte[] bdata = blob.getBytes(1, (int) blob.length());
                String description = new String(bdata);
                event.setDescription(description);
  /*              event.setNamePicture(resultSet.getString(TableColumnName.EVENT_DAO_PICTURE));
                event.setCountTickets(resultSet.getInt(TableColumnName.EVENT_DAO_COUNT_TICKETS));
                Timestamp t=resultSet.getTimestamp(TableColumnName.EVENT_DAO_MODIFY_DATE);
                LocalDateTime localDateTime=t.toLocalDateTime();
                event.setModifyDate(localDateTime);*/
                event.setShortDescription(resultSet.getString(TableColumnName.EVENT_DAO_SHORT_DESCRIPTION));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
        }
        return event;


    }

    @Override
    public boolean delete(Event entity) {
        return false;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }

    @Override
    public boolean create(Event entity) throws DaoException {
        Connection connection = this.connection;
        PreparedStatement statement = null;
        try {
            //typeevent,name,description,picture,counttickets,actflag,modifydate
            statement = connection.prepareStatement(INSERT_EVENT);
            statement.setString(1, entity.getEventType().toString());
            statement.setString(2, entity.getName());
            statement.setString(3, entity.getDescription());
            statement.setString(4,entity.getNamePicture());
            statement.setString(5,String.valueOf(entity.getCountTickets()));
            statement.setString(6,"1");
            int result = statement.executeUpdate();
            return result==1?true:false;
            }
        catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public Event update(Event entity) {
        return null;
    }
}
