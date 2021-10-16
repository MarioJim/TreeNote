package com.swdesignteam.TreeNote.model.note;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "notes")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "note_type")
public class Note {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column(name = "note_type", insertable = false, updatable = false)
  private String noteType;

  @ManyToOne
  @JoinColumn(referencedColumnName = "id")
  @JsonBackReference
  private Note parent;

  @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  private List<Note> children;

  @Column
  private double place;

  public Note() {}

  public Note(long id, Note parent, double place) {
    this.id = id;
    this.parent = parent;
    this.place = place;
  }

  public long getId() {
    return id;
  }

  public String getNoteType() {
    return noteType;
  }

  public Note getParent() {
    return parent;
  }

  public List<Note> getChildren() {
    return children;
  }

  public double getPlace() {
    return place;
  }

}
