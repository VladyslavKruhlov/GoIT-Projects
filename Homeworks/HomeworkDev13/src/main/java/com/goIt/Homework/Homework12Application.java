package com.goIt.Homework;

import com.goIt.Homework.Entity.Note;
import com.goIt.Homework.Services.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;


@SpringBootApplication
public class Homework12Application {
	public static void main(String[] args) {
		SpringApplication.run(Homework12Application.class, args);
	}
}

//@SpringBootApplication
//public class Homework12Application {
//	private NoteService noteService;
//
//	@Autowired
//	public Homework12Application(NoteService noteService) {
//		this.noteService = noteService;
//	}
//
//	public static void main(String[] args) {
//		NoteService noteService = new NoteService();
//		//NoteService noteService;
//
//		//Create
//		Note note1 = new Note("First", "Day1");
//		Note note2 = new Note("Second","Day2" );
//
//		//Add
//		noteService.add(note1);
//		noteService.add(note2);
//
//		//FindAll
//		for (Note note : noteService.listAll()) {
//			System.out.println("ID: " + note.getId() + ", Title: " + note.getTitle() + ", Content: " + note.getContent());
//		}
//
//		//Edit second note
//		note2.setTitle("Third");
//		note2.setContent("Day3");
//
//		//Update second note
//		noteService.update(note2);
//
//		//FindAll
//		for (Note note : noteService.listAll()) {
//			System.out.println("ID: " + note.getId() + ", Title: " + note.getTitle() + ", Content: " + note.getContent());
//		}
//
//		//Delete second note
//		noteService.deleteById(note2.getId());
//
//		//Find by id
//		System.out.println(noteService.getById(note1.getId()).toString());
//	}
//}


