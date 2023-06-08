package com.example.restapi.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.restapi.exception.ResourceNotFoundException;
import com.example.restapi.service.EventService;
import com.example.restapi.model.Event;
import com.example.restapi.repository.EventRepository;

@Service
public class EventServiceImpl implements EventService {

    private EventRepository eventRepository;
    public EventServiceImpl(EventRepository eventRepository) {
        super();
        this.eventRepository = eventRepository;
    }
    @Override
    public Event saveEvent(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public Event getEventById(long id) {
        return eventRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Event", "Id", id));
    }

    @Override
    public Event updateEvent(Event event, long id) {
        // need to check whether event with given id exists in DB
        Event existingEvent = eventRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Event", "Id", id));

        existingEvent.setEventName(event.getEventName());
        existingEvent.setEventStart(event.getEventStart());
        existingEvent.setEventEnd(event.getEventEnd());
        // save existing event to DB
        eventRepository.save(existingEvent);
        return existingEvent;
    }

    @Override
    public void deleteEvent(long id) {
        eventRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Event", "Id", id));
        eventRepository.deleteById(id);
    }
}
