package com.swdesignteam.TreeNote.service;

import com.swdesignteam.TreeNote.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BooksService {

  List<Book> getAllBooks();

  Book createBook(Book book);

  void updateBook(Book book);

  void deleteBookById(long id);

}
