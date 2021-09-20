package com.swdesignteam.TreeNote.repository;

import com.swdesignteam.TreeNote.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotesRepository extends JpaRepository<Note, Long> {

}
