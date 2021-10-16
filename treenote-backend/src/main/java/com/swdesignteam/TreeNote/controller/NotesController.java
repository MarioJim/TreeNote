package com.swdesignteam.TreeNote.controller;

import com.swdesignteam.TreeNote.model.note.Note;
import com.swdesignteam.TreeNote.model.request.NoteRequest;
import com.swdesignteam.TreeNote.repository.NotesRepository;
import com.swdesignteam.TreeNote.service.NotesService;
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
  NotesRepository notesRepository;

  @Autowired
  NotesService notesService;

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

  @PostMapping("/new")
  public ResponseEntity<Note> createNote(@RequestBody NoteRequest request) {
    return ResponseEntity.accepted().body(notesService.createNote(request));
  }

  @PostMapping("/update")
  public ResponseEntity<Note> updateNote(@RequestBody NoteRequest request) {
    return ResponseEntity.accepted().body(notesService.updateNote(request));
  }

  @GetMapping("/delete/{id}")
  public void deleteNote(@PathVariable("id") long id) {
    notesService.deleteNoteById(id);
  }

}
