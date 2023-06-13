package com.example.restapi.model.dao.impl;

import com.example.restapi.exception.ResourceNotFoundException;
import com.example.restapi.model.Event;
import com.example.restapi.model.dao.EventDAO;
import com.example.restapi.repository.EventRepository;
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
    public Event getById(long id) {
        return eventRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Event", "Id", id));
    }

    @Override
    public void delete(long id) {
        eventRepository.deleteById(id);
    }
}
