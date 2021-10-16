package com.swdesignteam.TreeNote.service;

import com.swdesignteam.TreeNote.model.Page;
import com.swdesignteam.TreeNote.model.note.Note;
import com.swdesignteam.TreeNote.model.request.PageRequest;
import org.springframework.stereotype.Service;

@Service
public interface PagesService {

  Note getNoteFromPageId(long id);

  Page createPage(PageRequest request);

  void updatePage(PageRequest request);

  void deletePageById(long id);

}
