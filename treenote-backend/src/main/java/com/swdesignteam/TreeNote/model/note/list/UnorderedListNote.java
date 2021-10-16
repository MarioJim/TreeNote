package com.swdesignteam.TreeNote.model.note.list;

import com.swdesignteam.TreeNote.model.note.Note;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity(name = "UnorderedListNote")
@DiscriminatorValue("UnorderedListNote")
public class UnorderedListNote extends Note {

  public UnorderedListNote() {}

  public UnorderedListNote(long id, Note parent, double place) {
    super(id, parent, place);
  }

}
