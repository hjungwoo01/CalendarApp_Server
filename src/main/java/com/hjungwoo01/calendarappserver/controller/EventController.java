package com.hjungwoo01.calendarappserver.controller;

import com.hjungwoo01.calendarappserver.model.Event;
import com.hjungwoo01.calendarappserver.service.EventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/db_calendar/scheduler")
public class EventController {
    private EventService eventService;

    public EventController(EventService eventService) {
        super();
        this.eventService = eventService;
    }

    @GetMapping("/get-all")
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @GetMapping("{id}")
    public ResponseEntity<Event> getEventById(@PathVariable("id") long eventId) {
        return new ResponseEntity<>(eventService.getEventById(eventId), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveEvent(@RequestBody Event event) {
        Event savedEvent = eventService.saveEvent(event);
        if (savedEvent != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Event added successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save event.");
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<String> updateEvent(@PathVariable ("id") long id, @RequestBody Event event) {
        Event updateEvent = eventService.updateEvent(event,id);
        if(updateEvent != null) {
            return ResponseEntity.status(HttpStatus.OK).body("Event updated.");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Event update failed.");
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEvent(@PathVariable("id") long id) {
        // delete event from DB
        eventService.deleteEvent(id);
        return new ResponseEntity<String>("Event deleted successfully.", HttpStatus.OK);
    }
}
