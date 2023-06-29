package com.hjungwoo01.calendarappserver.service.impl;

import java.util.List;

import com.hjungwoo01.calendarappserver.model.dao.event.EventDAO;
import com.hjungwoo01.calendarappserver.model.event.Event;
import org.springframework.stereotype.Service;

import com.hjungwoo01.calendarappserver.exception.ResourceNotFoundException;
import com.hjungwoo01.calendarappserver.service.EventService;

@Service
public class EventServiceImpl implements EventService {
    private final EventDAO eventDAO;

    public EventServiceImpl(EventDAO eventDAO) {
        this.eventDAO = eventDAO;
    }
    @Override
    public Event saveEvent(Event event) {
        return eventDAO.save(event);
    }

    @Override
    public List<Event> getAllEvents() {
        return eventDAO.getAll();
    }

    @Override
    public List<Event> getEventsByOwner(String owner) {
        return eventDAO.getByOwner(owner);
    }

    @Override
    public Event getEventById(long id) {
        Event event = eventDAO.getById(id);
        if (event == null) {
            throw new ResourceNotFoundException("Event", "Id", id);
        }
        return event;
    }

    @Override
    public Event updateEvent(Event event, long id) {
        Event existingEvent = getEventById(id);
        existingEvent.setOwner(event.getOwner());
        existingEvent.setEventName(event.getEventName());
        existingEvent.setEventMemo(event.getEventMemo());
        existingEvent.setEventStart(event.getEventStart());
        existingEvent.setEventEnd(event.getEventEnd());
        existingEvent.setEventRepeat(event.getEventRepeat());
        existingEvent.setEventEndRepeat(event.getEventEndRepeat());
        return eventDAO.save(existingEvent);
    }

    @Override
    public void deleteEvent(long id) {
        getEventById(id);
        eventDAO.delete(id);
    }
}
