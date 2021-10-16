package com.swdesignteam.TreeNote.model.request;

public class PageRequest {

  private long id;
  private final long book_id;
  private final String title;

  public PageRequest(long book_id, String title) {
    this.book_id = book_id;
    this.title = title;
  }

  public long getId() {
    return id;
  }

  public long getBookId() {
    return book_id;
  }

  public String getTitle() {
    return title;
  }

}
