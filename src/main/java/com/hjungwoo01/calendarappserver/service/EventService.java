package com.hjungwoo01.calendarappserver.service;

import com.hjungwoo01.calendarappserver.model.Event;

import java.util.List;
public interface EventService {
    // CRUD Operations
    Event saveEvent(Event event);
    List<Event> getAllEvents();
    Event getEventById(long id);
    Event updateEvent(Event event, long id);
    void deleteEvent(long id);
}