package com.swdesignteam.TreeNote.model.note.list;

import com.swdesignteam.TreeNote.model.note.Note;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "OrderedListNote")
@DiscriminatorValue("OrderedListNote")
public class OrderedListNote extends Note {

  public OrderedListNote() {}

  public OrderedListNote(long id, Note parent, double place) {
    super(id, parent, place);
  }

}
