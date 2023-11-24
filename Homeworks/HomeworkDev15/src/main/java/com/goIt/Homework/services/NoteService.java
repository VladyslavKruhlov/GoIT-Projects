package com.goIt.Homework.services;

import com.goIt.Homework.entity.Note;
import com.goIt.Homework.interfaces.NoteRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class NoteService {
    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public List<Note> listAll() {
        return noteRepository.findAll();
    }

    public Note getById(long id) {
        return noteRepository.findById(id).orElse(null);
    }

    public Note add(Note note) {
        return noteRepository.save(note);
    }

    public void deleteById(long id) {
            noteRepository.deleteById(id);
    }

    public void update(Note note) {
            noteRepository.save(note);
    }
}
