package com.goIt.Homework.Entity;

import lombok.Data;

import java.util.Random;

@Data
public class Note {
    private long id;
    private String title;
    private String content;

    public Note(String title, String content) {
        this.id = generateUniqueId();
        this.title = title;
        this.content = content;
    }

    private Long generateUniqueId() {
        Random random = new Random();
        return random.nextLong();
    }
}
