package com.swdesignteam.TreeNote.repository;

import com.swdesignteam.TreeNote.model.note.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface NotesRepository extends JpaRepository<Note, Long> {

  @Modifying
  @Query("UPDATE Note n SET n.noteType = :new_type WHERE n.id = :id")
  void updateType(@Param("id") long id, @Param("new_type") String newType);

}
