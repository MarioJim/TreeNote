package com.swdesignteam.TreeNote.service;

import com.swdesignteam.TreeNote.model.note.ImageNote;
import com.swdesignteam.TreeNote.model.note.Note;
import com.swdesignteam.TreeNote.model.note.text.TextNote;
import com.swdesignteam.TreeNote.model.note.text.TitleNote;
import com.swdesignteam.TreeNote.model.request.NoteRequest;
import com.swdesignteam.TreeNote.repository.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Objects;
import java.util.Optional;

@Service
public class NotesServiceImpl implements NotesService {

  @Autowired
  private NotesRepository notesRepository;

  @Autowired
  private NoteFactoryService noteFactoryService;

  @Override
  public Optional<Note> getNoteById(long id) {
    return notesRepository.findById(id);
  }

  @Override
  public Note createNote(NoteRequest request) {
    Note note = noteFactoryService.noteFromInsertReq(request);
    return notesRepository.saveAndFlush(note);
  }

  @Transactional
  @Override
  public Note updateNote(NoteRequest request) {
    Note oldNote = notesRepository.getById(request.getId());

    if (Objects.equals(oldNote.getNoteType(), request.getNoteType())) { // Same type
      Note newNote = noteFactoryService.noteFromInsertReq(request);
      oldNote.setParent(newNote.getParent());
      oldNote.setPlace(newNote.getPlace());
      switch (oldNote.getNoteType()) {
        case "TitleNote":
          ((TitleNote) oldNote).setSize(request.getSize());
        case "TextNode":
          ((TextNote) oldNote).setContent(request.getContent());
          break;
        case "ImageNote":
          ((ImageNote) oldNote).setSrc(request.getSrc());
          break;
      }
      notesRepository.saveAndFlush(oldNote);
      return oldNote;
    } else { // Different type
      request.setId(0);
      Note newNote = noteFactoryService.noteFromInsertReq(request);
      notesRepository.save(newNote);
      for (Note child : oldNote.getChildren()) {
        child.setParent(newNote);
      }
      newNote.addAllChildren(oldNote.getChildren());
      notesRepository.saveAll(oldNote.getChildren());
      notesRepository.saveAndFlush(newNote);
      oldNote.clearChildren();
      deleteNoteById(oldNote.getId());
      return newNote;
    }
  }

  @Override
  public void deleteNoteById(long id) {
    Note note = notesRepository.getById(id);
    Note parent = note.getParent();
    if (parent != null) {
      parent.removeChild(note);
      notesRepository.saveAndFlush(parent);
      notesRepository.delete(note);
    }
  }
}
