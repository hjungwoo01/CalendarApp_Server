package com.hjungwoo01.calendarappserver.service;

import com.hjungwoo01.calendarappserver.model.event.Event;

import java.util.List;
public interface EventService {
    Event saveEvent(Event event);
    List<Event> getAllEvents();
    List<Event> getEventsByOwner(String owner);
    Event getEventById(long id);
    Event updateEvent(Event event, long id);
    void deleteEvent(long id);

}