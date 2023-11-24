package com.goIt.Homework.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class User {
    @Id
    @GeneratedValue
    @Column(name="ID")
    private Long id;

    @Column(unique = true, name = "USERNAME")
    private String username;

    @Column(name="PASSWORD")
    private String password;

    @Column(name="ROLE")
    private String role;

    @Column(name="ENABLED")
    private boolean enabled;
}
