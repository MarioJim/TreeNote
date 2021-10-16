package com.swdesignteam.TreeNote.controller;

import com.swdesignteam.TreeNote.model.Page;
import com.swdesignteam.TreeNote.model.note.Note;
import com.swdesignteam.TreeNote.model.request.PageRequest;
import com.swdesignteam.TreeNote.service.PagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/pages")
public class PagesController {

  @Autowired
  PagesService pagesService;

  @GetMapping("/{id}")
  public ResponseEntity<Note> getPage(@PathVariable("id") long id) {
    return ResponseEntity.accepted().body(pagesService.getNoteFromPageId(id));
  }

  @PostMapping("/new")
  public ResponseEntity<Page> createPage(@RequestBody PageRequest page) {
    return ResponseEntity.accepted().body(pagesService.createPage(page));
  }

  @PostMapping("/update")
  public void updatePage(@RequestBody PageRequest page) {
    pagesService.updatePage(page);
  }

  @GetMapping("/delete/{id}")
  public void deletePage(@PathVariable("id") long id) {
    pagesService.deletePageById(id);
  }

}
