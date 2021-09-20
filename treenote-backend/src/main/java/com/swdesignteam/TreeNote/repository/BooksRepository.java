package com.swdesignteam.TreeNote.repository;

import com.swdesignteam.TreeNote.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository extends JpaRepository<Book, Long> {

}
