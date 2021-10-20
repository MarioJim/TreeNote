package com.swdesignteam.TreeNote.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PageRequest {

  private long id;
  @JsonProperty("book_id")
  private final long bookId;
  private final String title;

  public PageRequest(long bookId, String title) {
    this.bookId = bookId;
    this.title = title;
  }

  public long getId() {
    return id;
  }

  public long getBookId() {
    return bookId;
  }

  public String getTitle() {
    return title;
  }

}
