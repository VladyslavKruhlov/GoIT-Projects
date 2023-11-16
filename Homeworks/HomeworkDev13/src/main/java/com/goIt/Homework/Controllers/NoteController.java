package com.goIt.Homework.Controllers;

import com.goIt.Homework.Entity.Note;
import com.goIt.Homework.Services.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@RequiredArgsConstructor
@RequestMapping("/note")
    @Controller
    public class NoteController {

    private final NoteService noteService;

    @RequestMapping(value = "/list", method = {RequestMethod.GET})
    public ModelAndView getListAll() {
        ModelAndView result = new ModelAndView("note");
        result.addObject("object", noteService.listAll());
        return result;
    }

    @RequestMapping(value = "/add", method = {RequestMethod.POST})
    public String postAdd(@RequestParam("title") String title, @RequestParam("context") String context) {
        Note note = new Note(title, context);
        ModelAndView result = new ModelAndView("note");
        result.addObject("message", noteService.add(note));
        return "redirect:/note/list";
    }

    @RequestMapping(value = "/list/id", method = {RequestMethod.GET})
    public ModelAndView getListById(@RequestParam("id") long id) {
        ModelAndView result = new ModelAndView("note");
        result.addObject("object", noteService.getById(id));
        return result;
    }

    @RequestMapping(value = "/delete", method = {RequestMethod.POST})
    public String postDelete(@RequestParam("id") long id) {
        Note deletedNote = noteService.getById(id);
        if (deletedNote != null) {
            noteService.deleteById(id);
        } else {
            System.out.println("Error, you can`t delete");
        }
        return "redirect:/note/list";
    }


    @RequestMapping(value = "/edit", method = {RequestMethod.GET})
    public ModelAndView getNoteEdit(@RequestParam("id") long id) {
        ModelAndView result = new ModelAndView("note");
        Note note = noteService.getById(id);
        result.addObject("object", note);
        return result;
    }

    @RequestMapping(value = "/edit", method = {RequestMethod.POST})
    public String postNoteEdit(@RequestParam("id") long id, @RequestParam("title") String title, @RequestParam("context") String context) {

        Note editedNote = noteService.getById(id);
        if (editedNote!=null){
            editedNote.setTitle(title);
            editedNote.setContent(context);
            noteService.update(editedNote);
        }
        return "redirect:/note/list";
    }
}