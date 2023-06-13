package com.example.restapi.model;

import java.util.List;

public interface EventDAO {
    Event save(Event event);
    List<Event> getAll();
    Event getById(long id);
    void delete(long id);
}