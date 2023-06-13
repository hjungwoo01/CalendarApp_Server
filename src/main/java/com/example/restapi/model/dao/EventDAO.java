package com.example.restapi.model.dao;

import com.example.restapi.model.Event;

import java.util.List;

public interface EventDAO {
    Event save(Event event);
    List<Event> getAll();
    Event getById(long id);
    void delete(long id);
}