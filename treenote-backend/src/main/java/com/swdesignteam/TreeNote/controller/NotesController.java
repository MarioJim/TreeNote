package com.swdesignteam.TreeNote.controller;

import com.swdesignteam.TreeNote.model.Book;
import com.swdesignteam.TreeNote.model.note.Note;
import com.swdesignteam.TreeNote.repository.BooksRepository;
import com.swdesignteam.TreeNote.repository.NotesRepository;
import com.swdesignteam.TreeNote.repository.PagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/notes")
public class NotesController {

  @Autowired
  BooksRepository booksRepository;

  @Autowired
  PagesRepository pagesRepository;

  @Autowired
  NotesRepository notesRepository;

  @GetMapping("/")
  public ResponseEntity<List<Note>> getAllNotes() {
    return new ResponseEntity<>(notesRepository.findAll(), HttpStatus.ACCEPTED);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Note> getNoteById(@PathVariable("id") long id) {
    return notesRepository.findById(id)
        .map(note -> new ResponseEntity<>(note, HttpStatus.ACCEPTED))
        .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @GetMapping("/books")
  public ResponseEntity<List<Book>> getAllBooks() {
    return ResponseEntity.accepted().body(booksRepository.findAll());
  }

}
