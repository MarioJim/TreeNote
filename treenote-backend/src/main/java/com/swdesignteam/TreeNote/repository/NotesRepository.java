package com.swdesignteam.TreeNote.repository;

import com.swdesignteam.TreeNote.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotesRepository extends JpaRepository<Note, Long> {
  List<Note> findAllByTitleContaining(String title);
}
