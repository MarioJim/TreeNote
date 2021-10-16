package com.swdesignteam.TreeNote.service;

import com.swdesignteam.TreeNote.model.Book;
import com.swdesignteam.TreeNote.model.Page;
import com.swdesignteam.TreeNote.model.note.Note;
import com.swdesignteam.TreeNote.model.request.PageRequest;
import com.swdesignteam.TreeNote.repository.BooksRepository;
import com.swdesignteam.TreeNote.repository.NotesRepository;
import com.swdesignteam.TreeNote.repository.PagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class PagesServiceImpl implements PagesService {

  @Autowired
  NotesRepository notesRepository;

  @Autowired
  PagesRepository pagesRepository;

  @Autowired
  BooksRepository booksRepository;

  @Transactional
  @Override
  public Page createPage(PageRequest request) {
    Book book = booksRepository.getById(request.getBookId());
    Page newPage = new Page(request.getId(), book, request.getTitle());
    Note note = new Note();
    note = notesRepository.saveAndFlush(note);
    newPage.setNote(note);
    return pagesRepository.saveAndFlush(newPage);
  }

  @Override
  public void updatePage(PageRequest request) {
    Page page = pagesRepository.getById(request.getId());
    page.setBook(booksRepository.getById(request.getBookId()));
    page.setTitle(request.getTitle());
    pagesRepository.saveAndFlush(page);
  }

  @Override
  public void deletePageById(long id) {
    Page page = pagesRepository.getById(id);
    Book book = page.getBook();
    if (book.getPages().size() == 1) {
      booksRepository.delete(book);
    } else {
      book.getPages().remove(page);
      pagesRepository.delete(page);
    }
  }

}
