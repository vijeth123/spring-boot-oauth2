package com.vijeth.mvc.repository;

import com.vijeth.mvc.model.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {
    public List<Book> findByTitle(String title);
}

