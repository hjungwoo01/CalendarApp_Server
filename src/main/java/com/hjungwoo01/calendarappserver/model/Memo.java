package com.hjungwoo01.calendarappserver.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "memos")
public class Memo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "receiver")
    private String receiver;

    @Column(name = "memo", nullable = false)
    private String memo;
}
