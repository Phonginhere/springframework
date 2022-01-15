package com.project.book.repositories;

import com.project.book.model.Book;
import com.project.book.model.User;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, String> {
}
