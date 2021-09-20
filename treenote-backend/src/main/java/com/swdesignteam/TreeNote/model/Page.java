package com.swdesignteam.TreeNote.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "pages")
public class Page {

  public Page() {}

  public Page(Book b, Note n) {
    this.book = b;
    this.note = n;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @ManyToOne
  @JoinColumn(name = "book_id", referencedColumnName = "id")
  private Book book;

  @OneToOne(optional = false, fetch = FetchType.LAZY)
  @JoinColumn(name = "note_id", referencedColumnName = "id")
  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
  private Note note;

  public long getId() {
    return id;
  }

  public Note getNote() {
    return note;
  }
}
