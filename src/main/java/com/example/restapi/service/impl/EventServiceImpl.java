package com.example.restapi.service.impl;

import java.util.List;

import com.example.restapi.model.EventDAO;
import org.springframework.stereotype.Service;

import com.example.restapi.exception.ResourceNotFoundException;
import com.example.restapi.service.EventService;
import com.example.restapi.model.Event;

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
        existingEvent.setEventName(event.getEventName());
        existingEvent.setEventMemo(event.getEventMemo());
        existingEvent.setEventStart(event.getEventStart());
        existingEvent.setEventEnd(event.getEventEnd());
        existingEvent.setEventRepeat(event.getEventRepeat());
        return eventDAO.save(existingEvent);
    }

    @Override
    public void deleteEvent(long id) {
        getEventById(id);
        eventDAO.delete(id);
    }
}
