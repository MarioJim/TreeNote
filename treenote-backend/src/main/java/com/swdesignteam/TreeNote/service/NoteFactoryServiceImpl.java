package com.swdesignteam.TreeNote.service;

import com.swdesignteam.TreeNote.model.note.ImageNote;
import com.swdesignteam.TreeNote.model.note.Note;
import com.swdesignteam.TreeNote.model.note.list.OrderedListNote;
import com.swdesignteam.TreeNote.model.note.list.UnorderedListNote;
import com.swdesignteam.TreeNote.model.note.text.CodeNote;
import com.swdesignteam.TreeNote.model.note.text.TextNote;
import com.swdesignteam.TreeNote.model.note.text.TitleNote;
import com.swdesignteam.TreeNote.model.request.NoteRequest;
import com.swdesignteam.TreeNote.repository.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoteFactoryServiceImpl implements NoteFactoryService {

  @Autowired
  NotesRepository notesRepository;

  @Override
  public Note noteFromInsertReq(NoteRequest request) {
    System.out.println(request);
    Note parent = notesRepository.getById(request.getParentId());
    switch (request.getNoteType()) {
      case "Note":
        return new Note(request.getId(), parent, request.getPlace());
      case "TextNote":
        return new TextNote(request.getId(), parent, request.getPlace(), request.getContent());
      case "CodeNote":
        return new CodeNote(request.getId(), parent, request.getPlace(), request.getContent());
      case "TitleNote":
        return new TitleNote(request.getId(), parent, request.getPlace(), request.getContent(), request.getSize());
      case "ImageNote":
        return new ImageNote(request.getId(), parent, request.getPlace(), request.getSrc());
      case "OrderedListNote":
        return new OrderedListNote(request.getId(), parent, request.getPlace());
      case "UnorderedListNote":
        return new UnorderedListNote(request.getId(), parent, request.getPlace());
    }
    throw new IllegalArgumentException("Invalid key 'note_type', got " + request.getNoteType());
  }

}
