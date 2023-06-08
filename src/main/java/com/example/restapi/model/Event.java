package com.example.restapi.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "event_name", nullable = false)
    private String eventName;

    @Column(name = "event_start")
    private int eventStart;

    @Column(name = "event_end")
    private int eventEnd;
}