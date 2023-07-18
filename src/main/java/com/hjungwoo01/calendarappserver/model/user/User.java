package com.hjungwoo01.calendarappserver.model.user;

import jakarta.persistence.*;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

@Data
@Entity
@Table(schema = "user", name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(name = "uuid")
    private String uuid;

    @NotNull
    @Column(name = "name")
    private String name;

    @Column(name = "face")
    private String face;
}