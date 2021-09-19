package com.swdesignteam.TreeNote.controller;

import com.swdesignteam.TreeNote.model.Note;
import com.swdesignteam.TreeNote.repository.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class NotesController {

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


}
