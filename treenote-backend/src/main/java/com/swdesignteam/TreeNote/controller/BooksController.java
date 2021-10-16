package com.swdesignteam.TreeNote.controller;


import com.swdesignteam.TreeNote.model.Book;
import com.swdesignteam.TreeNote.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/books")
public class BooksController {

  @Autowired
  BooksService booksService;

  @GetMapping("/")
  public ResponseEntity<List<Book>> getBooks() {
    return ResponseEntity.accepted().body(booksService.getAllBooks());
  }

  @Transactional
  @PostMapping("/new")
  public ResponseEntity<Book> createBook(@RequestBody Book book) {
    return ResponseEntity.accepted().body(booksService.createBook(book));
  }

  @PostMapping("/update")
  public void updateBook(@RequestBody Book book) {
    booksService.updateBook(book);
  }

  @GetMapping("/delete/{id}")
  public void deleteBook(@PathVariable("id") long id) {
    booksService.deleteBookById(id);
  }

}
