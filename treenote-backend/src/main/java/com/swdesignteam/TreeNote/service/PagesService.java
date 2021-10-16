package com.swdesignteam.TreeNote.service;

import com.swdesignteam.TreeNote.model.Page;
import com.swdesignteam.TreeNote.model.request.PageRequest;
import org.springframework.stereotype.Service;

@Service
public interface PagesService {

  Page createPage(PageRequest request);

  void updatePage(PageRequest request);

  void deletePageById(long id);

}
