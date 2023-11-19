package com.goIt.Homework.Controllers;

import com.goIt.Homework.Entity.Note;
import com.goIt.Homework.Services.NoteService;
import exceptionDTO.ExceptionDTO;
import excptions.MyException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/note")
    @Controller
    public class NoteController {

    private final NoteService noteService;

    @RequestMapping(value = "/list", method = {RequestMethod.GET})
    public String getListAll(Model model) {
        List<Note> noteList = noteService.listAll();
        model.addAttribute("noteList", noteList);
        return "list";
    }

    @RequestMapping(value = "/add", method = {RequestMethod.POST})
    public String postAdd(@RequestParam("title") String title, @RequestParam("content") String content, Model model) {
        Note note = new Note(title, content);
        Note addedNote = noteService.add(note);
        model.addAttribute("note", addedNote);
        return "redirect:/note/list";
    }

    @RequestMapping(value = "/list/id", method = {RequestMethod.GET})
    public String getListById(@RequestParam("id") long id, Model model) {
        Note note = noteService.getById(id);
        if (note != null) {
            model.addAttribute("note", note);
            return "noteById";
        } else {
            return "sorryPage";
        }
    }

    @RequestMapping(value = "/delete", method = {RequestMethod.POST})
    public String postDelete(@RequestParam("id") long id) {
        Note deletedNote = noteService.getById(id);
        if (deletedNote != null) {
            noteService.deleteById(id);
            return "redirect:/note/list";
        } else {
            return "sorryPage";
        }
    }

    @GetMapping("/edit")
    public String editNoteForm(@RequestParam("id") long id, Model model) {
        Note note = noteService.getById(id);
        if (note!=null){
            model.addAttribute("note", note);

        } else {
            throw new MyException("Something wrong with note parameters");
            //return "sorryPage";
        }
        return "edit";
    }
    @RequestMapping(value = "/edit", method = {RequestMethod.POST})
    public String postNoteEdit(@RequestParam("id") long id, @RequestParam("title") String title, @RequestParam("content") String content) {

        Note editedNote = noteService.getById(id);
        if (editedNote!=null){
            editedNote.setTitle(title);
            editedNote.setContent(content);
            noteService.update(editedNote);
        } else {
            throw new MyException("Error");
        }
        return "redirect:/note/list";
    }
    @ExceptionHandler(IOException.class)
    public ResponseEntity<ExceptionDTO> handleIOException(MyException ex) {
        final ExceptionDTO exceptionDTO = new ExceptionDTO(1L, ex.getMessage(), 404);
        return new ResponseEntity<>(exceptionDTO, HttpStatusCode.valueOf(exceptionDTO.getCode()));
    }
}

