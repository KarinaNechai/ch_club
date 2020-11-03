package com.charakhovich.club.model.service;

import com.charakhovich.club.model.entity.Event;
import com.charakhovich.club.model.exeption.ServiceException;

import java.util.List;

public interface EventService {
    List<Event> findAll() throws ServiceException;
    boolean create(Event entity) throws ServiceException;
    Event findEntityById(long id) throws ServiceException;
}
