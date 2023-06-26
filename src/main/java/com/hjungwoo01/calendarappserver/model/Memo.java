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

    @Column(name = "owner")
    private String owner;

    @Column(name = "receiver")
    private String receiver;

    @Column(name = "memo_name")
    private String memoName;

    @Column(name = "memo")
    private String memo;

    @Column(name = "date")
    private String date;
}
