package com.swdesignteam.TreeNote.service;

import com.swdesignteam.TreeNote.model.note.Note;
import com.swdesignteam.TreeNote.model.request.NoteRequest;
import org.springframework.stereotype.Service;

@Service
public interface NoteFactoryService {

  Note newNote(NoteRequest request);

}
