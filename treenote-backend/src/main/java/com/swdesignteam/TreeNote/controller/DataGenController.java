package com.swdesignteam.TreeNote.controller;


import com.swdesignteam.TreeNote.model.Book;
import com.swdesignteam.TreeNote.repository.BooksRepository;
import com.swdesignteam.TreeNote.repository.NotesRepository;
import com.swdesignteam.TreeNote.repository.PagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/generate")
public class DataGenController {

  @Autowired
  BooksRepository booksRepository;

  @Autowired
  PagesRepository pagesRepository;

  @Autowired
  NotesRepository notesRepository;

  @Transactional
  @GetMapping("/")
  public ResponseEntity<Book> generateDummyData() {
    System.out.println("todo");
    return null;
  }

}
