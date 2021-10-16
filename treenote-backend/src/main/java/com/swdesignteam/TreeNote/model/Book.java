package com.swdesignteam.TreeNote.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "books")
public class Book {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  @Column
  private String title;
  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "book")
  private List<Page> pages;

  public Book() {}

  public Book(String title) {
    this.title = title;
  }

  public long getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public List<Page> getPages() {
    return pages;
  }

  @Override
  public String toString() {
    return "Book{" +
        "id=" + id +
        ", title='" + title + '\'' +
        ", pages=" + pages +
        '}';
  }
}
