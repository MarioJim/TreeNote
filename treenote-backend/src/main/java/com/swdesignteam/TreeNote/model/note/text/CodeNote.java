package com.swdesignteam.TreeNote.model.note.text;

import com.swdesignteam.TreeNote.model.note.Note;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "CodeNote")
@DiscriminatorValue("CodeNote")
public class CodeNote extends TextNote {

  public CodeNote() {}

  public CodeNote(long id, Note parent, double place, String content) {
    super(id, parent, place, content);
  }

}
