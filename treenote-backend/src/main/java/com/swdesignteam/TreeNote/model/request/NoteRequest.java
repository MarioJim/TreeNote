package com.swdesignteam.TreeNote.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NoteRequest {

  // Note
  private long id;
  @JsonProperty("parent_id")
  private long parentId;
  private double place;
  @JsonProperty("note_type")
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

  public void setId(long id) {
    this.id = id;
  }

  public long getParentId() {
    return parentId;
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

  @Override
  public String toString() {
    return "NoteRequest{" +
        "id=" + id +
        ", parent_id=" + parentId +
        ", place=" + place +
        ", note_type='" + noteType + '\'' +
        ", content='" + content + '\'' +
        ", size=" + size +
        ", src='" + src + '\'' +
        '}';
  }
}
