package com.swdesignteam.TreeNote.model.note.text;

import com.swdesignteam.TreeNote.model.note.Note;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity(name = "TitleNote")
@DiscriminatorValue("TitleNote")
public class TitleNote extends TextNote {

  @Column
  private int size;

  public TitleNote() {}

  public TitleNote(long id, Note parent, double place, String content, int size) {
    super(id, parent, place, content);
    this.size = size;
  }

  public int getSize() {
    return size;
  }

}
