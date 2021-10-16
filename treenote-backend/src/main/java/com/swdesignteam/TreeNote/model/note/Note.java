package com.swdesignteam.TreeNote.model.note;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
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
  @OrderBy("place")
  private List<Note> children;

  @Column
  private double place;

  public Note() {
    this.place = 1;
  }

  public Note(long id, Note parent, double place) {
    this.id = id;
    this.parent = parent;
    this.place = place;
  }

  public long getId() {
    return id;
  }

  @JsonProperty("note_type")
  public String getNoteType() {
    return noteType;
  }

  public Note getParent() {
    return parent;
  }

  public void setParent(Note parent) {
    this.parent = parent;
  }

  public List<Note> getChildren() {
    return children;
  }

  public void clearChildren() {
    this.children = List.of();
  }

  public void addAllChildren(Collection<Note> children) {
    if (this.children == null) {
      this.children = new ArrayList<>();
    }
    this.children.addAll(children);
  }

  public void removeChild(Note note) {
    if (this.children != null) {
      this.children.remove(note);
    }
  }

  public double getPlace() {
    return place;
  }

  public void setPlace(double place) {
    this.place = place;
  }
}
