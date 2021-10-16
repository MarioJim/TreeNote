package com.swdesignteam.TreeNote.model.note.text;

import com.swdesignteam.TreeNote.model.note.Note;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "TextNote")
@DiscriminatorValue("TextNote")
public class TextNote extends Note {

  @Column
  private String content;

  public TextNote() {}

  public TextNote(long id, Note parent, double place, String content) {
    super(id, parent, place);
    this.content = content;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }
}
