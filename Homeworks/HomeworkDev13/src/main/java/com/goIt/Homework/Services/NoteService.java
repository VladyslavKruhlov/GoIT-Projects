package com.goIt.Homework.Services;

import com.goIt.Homework.Entity.Note;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class NoteService {
    public List<Note> noteList = new ArrayList<>();

    public List<Note> listAll() {
        return noteList;
    }

    public Note getById(long id) {
        return noteList.stream()
                .filter(note -> note.getId() == id)
                .findFirst().orElse(null);
    }

    public Note add(Note note) {
        noteList.add(note);
        return note;
    }

    public void deleteById(long id) {
        noteList.removeIf(note -> note.getId() == id);
    }

    public Note update(Note note) {
        if (getById(note.getId()) != null) {
            deleteById(note.getId());
            noteList.add(note);
        } else {
            System.out.println("Could find this note");
        }
        return note;
    }
}
