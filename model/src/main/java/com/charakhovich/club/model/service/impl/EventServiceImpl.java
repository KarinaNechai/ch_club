package com.charakhovich.club.model.service.impl;

import com.charakhovich.club.model.dao.EntityTransaction;
import com.charakhovich.club.model.dao.impl.EventDaoImpl;
import com.charakhovich.club.model.entity.Event;
import com.charakhovich.club.model.exeption.DaoException;
import com.charakhovich.club.model.exeption.ServiceException;
import com.charakhovich.club.model.service.EventService;

import java.util.List;

public class EventServiceImpl  implements EventService {
    @Override
    public List<Event> findAll() throws ServiceException {
        EventDaoImpl eventDao = new EventDaoImpl();
        EntityTransaction transaction = new EntityTransaction();
        transaction.init(eventDao);
        List<Event> result ;
        try {
            result = eventDao.findAll();
        } catch (DaoException e) {
            transaction.rollback();
            throw new ServiceException(e);
        } finally {
            transaction.end();
        }
        return result;
    }

    @Override
    public boolean create(Event entity) throws ServiceException {
        EventDaoImpl eventDao = new EventDaoImpl();
        EntityTransaction transaction = new EntityTransaction();
        transaction.init(eventDao);
        try {
            boolean result =eventDao.create(entity);
            return result;
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        finally {
            transaction.end();
        }

    }

    @Override
    public Event findEntityById(long id) throws ServiceException {
        EventDaoImpl eventDao = new EventDaoImpl();
        EntityTransaction transaction = new EntityTransaction();
        transaction.init(eventDao);
        try {
            Event result =eventDao.findEntityById(id);
            return result;
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        finally {
            transaction.end();
        }
    }
}
