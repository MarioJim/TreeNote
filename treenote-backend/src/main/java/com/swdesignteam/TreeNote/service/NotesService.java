package com.swdesignteam.TreeNote.service;

import com.swdesignteam.TreeNote.model.note.Note;
import com.swdesignteam.TreeNote.model.request.NoteRequest;

public interface NotesService {

  Note createNote(NoteRequest request);

  void updateNote(NoteRequest request);

  void deleteNoteById(long id);

}
