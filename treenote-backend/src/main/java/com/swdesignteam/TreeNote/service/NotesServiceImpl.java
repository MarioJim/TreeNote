package com.swdesignteam.TreeNote.service;

import com.swdesignteam.TreeNote.model.note.Note;
import com.swdesignteam.TreeNote.model.request.NoteRequest;
import com.swdesignteam.TreeNote.repository.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class NotesServiceImpl implements NotesService {

  @Autowired
  NotesRepository notesRepository;

  @Autowired
  NoteFactoryService noteFactoryService;

  @Override
  public Note createNote(NoteRequest request) {
    Note note = noteFactoryService.newNote(request);
    return notesRepository.saveAndFlush(note);
  }

  @Override
  public void updateNote(NoteRequest request) {
    Note note = notesRepository.getById(request.getId());
  }

  @Override
  public void deleteNoteById(long id) {
    Note note = notesRepository.getById(id);
    if (note.getParent() != null) {
      notesRepository.delete(note);
    }
  }
}
