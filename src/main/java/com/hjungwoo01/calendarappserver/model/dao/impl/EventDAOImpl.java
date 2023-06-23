package com.hjungwoo01.calendarappserver.model.dao.impl;

import com.hjungwoo01.calendarappserver.exception.ResourceNotFoundException;
import com.hjungwoo01.calendarappserver.model.Event;
import com.hjungwoo01.calendarappserver.model.dao.EventDAO;
import com.hjungwoo01.calendarappserver.repository.EventRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EventDAOImpl implements EventDAO {

    private final EventRepository eventRepository;

    public EventDAOImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public Event save(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public List<Event> getAll() {
        return eventRepository.findAll();
    }

    @Override
    public List<Event> getByOwner(String owner) {
        return eventRepository.findByOwner(owner);
    }

    @Override
    public Event getById(long id) {
        return eventRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Event", "Id", id));
    }

    @Override
    public void delete(long id) {
        eventRepository.deleteById(id);
    }
}
