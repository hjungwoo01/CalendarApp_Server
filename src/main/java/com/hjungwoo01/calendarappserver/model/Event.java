package com.hjungwoo01.calendarappserver.model;

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
    @Column(name = "owner")
    private String owner;

    @NotNull
    @Column(name = "event_name")
    private String eventName;

    @Column(name = "event_memo")
    private String eventMemo;

    @NotNull
    //yyyyMMddHHmm format
    @Column(name = "event_start")
    private String eventStart;

    @NotNull
    //yyyyMMddHHmm format
    @Column(name = "event_end")
    private String eventEnd;

    @Column(name = "event_repeat")
    private String eventRepeat;

    //yyyyMMdd format
    @Column(name = "event_endrepeat")
    private String eventEndRepeat;
}