package com.example.restapi.model;

import jakarta.persistence.*;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;


@Data
@Entity
@Table(name = "scheduler")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(name = "event_name")
    private String eventName;

    @Column(name = "event_memo")
    private String eventMemo;

    //YYYYMMDDHHMM
    @Column(name = "event_start")
    private int eventStart;

    //YYYYMMDDHHMM
    @Column(name = "event_end")
    private int eventEnd;

    //YYYYMMDDHHMM -> start date repeat?
    @Column(name = "event_repeat")
    private int eventRepeat;
}