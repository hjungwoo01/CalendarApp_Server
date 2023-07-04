package com.hjungwoo01.calendarappserver.model.file;

import jakarta.persistence.*;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

@Data
@Entity
@Table(schema = "memos", name = "files")
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(name = "memoId")
    private long memoId;

    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "type")
    private String type;

    @Lob
    @NotNull
    @Column(name = "data")
    private byte[] data;
}