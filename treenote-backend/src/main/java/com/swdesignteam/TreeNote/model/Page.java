package com.swdesignteam.TreeNote.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.swdesignteam.TreeNote.model.note.Note;

import javax.persistence.*;

@Entity
@Table(name = "pages")
public class Page {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @ManyToOne
  @JoinColumn(name = "book_id", referencedColumnName = "id")
  @JsonIgnore
  private Book book;

  @Column
  private String title;

  @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "note_id", referencedColumnName = "id")
  @JsonIgnore
  private Note note;

  public Page() {}

  public Page(Book b, String title) {
    this.book = b;
    this.title = title;
  }

  public Page(long id, Book b, String title) {
    this.id = id;
    this.book = b;
    this.title = title;
  }

  public long getId() {
    return id;
  }

  public Book getBook() {
    return book;
  }

  public void setBook(Book book) {
    this.book = book;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Note getNote() {
    return note;
  }

  public void setNote(Note note) {
    this.note = note;
  }
}
