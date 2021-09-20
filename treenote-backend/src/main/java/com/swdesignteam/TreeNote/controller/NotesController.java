package com.swdesignteam.TreeNote.controller;

import com.swdesignteam.TreeNote.model.Book;
import com.swdesignteam.TreeNote.model.Note;
import com.swdesignteam.TreeNote.model.Page;
import com.swdesignteam.TreeNote.model.note.TextNote;
import com.swdesignteam.TreeNote.repository.BooksRepository;
import com.swdesignteam.TreeNote.repository.NotesRepository;
import com.swdesignteam.TreeNote.repository.PagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class NotesController {

  @Autowired
  BooksRepository booksRepository;

  @Autowired
  PagesRepository pagesRepository;

  @Autowired
  NotesRepository notesRepository;

  @GetMapping("/notes")
  public ResponseEntity<List<Note>> getAllNotes() {
    return new ResponseEntity<>(notesRepository.findAll(), HttpStatus.ACCEPTED);
  }

  @GetMapping("/notes/{id}")
  public ResponseEntity<Note> getNoteById(@PathVariable("id") long id) {
    return notesRepository.findById(id)
        .map(note -> new ResponseEntity<>(note, HttpStatus.ACCEPTED))
        .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @GetMapping("/xd")
  public ResponseEntity<List<Long>> testGet() {
    var a = new ArrayList<Long>();
    a.add(2L);
    a.add(4L);
    a.add(6L);
    return new ResponseEntity<>(a, HttpStatus.ACCEPTED);
  }

  @GetMapping("/dummydata")
  public ResponseEntity<Book> generateDummyData() {
    Note n = new TextNote("text noteeeee");
    n = notesRepository.saveAndFlush(n);
    Book b = new Book("dummy book");
    b = booksRepository.saveAndFlush(b);
    Page p = new Page(b, n);
    p = pagesRepository.saveAndFlush(p);
    return ResponseEntity.accepted().body(b);
  }

  @GetMapping("/books")
  public ResponseEntity<List<Book>> getAllBooks() {
    return ResponseEntity.accepted().body(booksRepository.findAll());
  }

}
