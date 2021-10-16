package com.swdesignteam.TreeNote.model.request;

public class NoteRequest {

  // Note
  private long id;
  private long parent;
  private double place;
  private String noteType;
  // CodeNote, TextNote
  private String content;
  // TitleNote
  private int size;
  // ImageNote
  private String src;

  public long getId() {
    return id;
  }

  public long getParent() {
    return parent;
  }

  public double getPlace() {
    return place;
  }

  public String getNoteType() {
    return noteType;
  }

  public String getContent() {
    return content;
  }

  public int getSize() {
    return this.size;
  }

  public String getSrc() {
    return src;
  }
}
