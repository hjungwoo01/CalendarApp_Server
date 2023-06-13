package com.hjungwoo01.calendarappserver.model.dao;

import com.hjungwoo01.calendarappserver.model.Event;

import java.util.List;

public interface EventDAO {
    Event save(Event event);
    List<Event> getAll();
    Event getById(long id);
    void delete(long id);
}