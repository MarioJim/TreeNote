package com.swdesignteam.TreeNote.model.note;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "ImageNote")
@DiscriminatorValue("ImageNote")
public class ImageNote extends Note {

  @Column
  private String src;

  public ImageNote() {}

  public ImageNote(long id, Note parent, double place, String src) {
    super(id, parent, place);
    this.src = src;
  }

  public String getSrc() {
    return src;
  }

}
