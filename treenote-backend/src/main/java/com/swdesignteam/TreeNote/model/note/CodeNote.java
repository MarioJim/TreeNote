package com.swdesignteam.TreeNote.model.note;

import com.swdesignteam.TreeNote.model.Note;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "CodeNote")
@DiscriminatorValue("CodeNote")
public class CodeNote extends Note {

  @Column
  private String content;

}
