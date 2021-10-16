package com.swdesignteam.TreeNote.service;

import com.swdesignteam.TreeNote.model.Book;
import com.swdesignteam.TreeNote.model.request.PageRequest;
import com.swdesignteam.TreeNote.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BooksServiceImpl implements BooksService {

  @Autowired
  BooksRepository booksRepository;

  @Autowired
  PagesService pagesService;

  public List<Book> getAllBooks() {
    return booksRepository.findAll();
  }

  @Transactional
  @Override
  public Book createBook(Book book) {
    Book createdBook = booksRepository.saveAndFlush(book);
    pagesService.createPage(new PageRequest(book.getId(), "New Page"));
    return createdBook;
  }

  @Override
  public void updateBook(Book book) {
    booksRepository.saveAndFlush(book);
  }

  @Override
  public void deleteBookById(long id) {
    booksRepository.deleteById(id);
  }
}
