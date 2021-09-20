package com.swdesignteam.TreeNote.model.note;

import com.swdesignteam.TreeNote.model.Note;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "TextNote")
@DiscriminatorValue("TextNote")
public class TextNote extends Note {

  public TextNote() {}

  public TextNote(String content) {
    this.content = content;
  }

  @Column
  private String content;

  public String getContent() {
    return content;
  }
}
