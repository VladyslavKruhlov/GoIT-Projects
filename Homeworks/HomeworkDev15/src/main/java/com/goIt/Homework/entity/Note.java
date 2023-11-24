package com.goIt.Homework.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="Note")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="TITLE", length = 200)
    private String title;

    @Column(name="CONTENT", length = 500)
    private String content;
}

