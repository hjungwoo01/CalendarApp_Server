package com.hjungwoo01.calendarappserver.model.memo;

import jakarta.persistence.*;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

@Data
@Entity
@Table(schema = "memos", name = "memos")
public class Memo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(name = "owner")
    private String owner;

    @NotNull
    @Column(name = "receiver")
    private String receiver;

    @NotNull
    @Column(name = "memo_name")
    private String memoName;

    @Column(name = "memo")
    private String memo;

    @NotNull
    @Column(name = "date")
    private String date;

    @Column(name = "readReceivers")
    private String readReceivers;
}
