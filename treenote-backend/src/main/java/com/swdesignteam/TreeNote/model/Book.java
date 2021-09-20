package com.swdesignteam.TreeNote.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "books")
public class Book {

  public Book() {}

  public Book(String title) {
    this.title = title;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column(name = "title")
  private String title;

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "book")
  private List<Page> pages;

  public long getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public List<Page> getPages() {
    return pages;
  }

}
