package com.hjungwoo01.calendarappserver.repositories.event;

import com.hjungwoo01.calendarappserver.model.event.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findByOwner(String owner);
}