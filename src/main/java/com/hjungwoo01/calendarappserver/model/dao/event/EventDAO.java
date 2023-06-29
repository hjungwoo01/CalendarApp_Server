package com.hjungwoo01.calendarappserver.model.dao.event;

import com.hjungwoo01.calendarappserver.model.event.Event;

import java.util.List;

public interface EventDAO {
    Event save(Event event);
    List<Event> getAll();
    Event getById(long id);
    void delete(long id);
    List<Event> getByOwner(String owner);
}