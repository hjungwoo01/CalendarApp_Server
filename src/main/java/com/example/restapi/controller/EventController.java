package com.example.restapi.controller;

import com.example.restapi.model.Event;
import com.example.restapi.service.EventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/db_calendar/events")
public class EventController {
    private EventService eventService;

    public EventController(EventService eventService) {
        super();
        this.eventService = eventService;
    }

    @GetMapping
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @GetMapping("{id}")
    public ResponseEntity<Event> getEventById(@PathVariable("id") long eventId) {
        return new ResponseEntity<Event>(eventService.getEventById(eventId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Event> saveEvent(@RequestBody Event event) {
        return new ResponseEntity<>(eventService.saveEvent(event), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Event> updateEvent(@PathVariable ("id") long id, @RequestBody Event event) {
        return new ResponseEntity<Event>(eventService.updateEvent(event, id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEvent(@PathVariable("id") long id) {
        // delete event from DB
        eventService.deleteEvent(id);
        return new ResponseEntity<String>("Event deleted successfully.", HttpStatus.OK);
    }
}
