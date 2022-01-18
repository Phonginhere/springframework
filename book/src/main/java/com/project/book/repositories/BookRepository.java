package com.project.book.repositories;

import com.project.book.model.Book;
import com.project.book.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

public interface BookRepository extends CrudRepository<Book, String> {
    @Query(value = "select b.BookId, b.Title, c.CategoryName, b.Price from books b INNER join category c on b.CategoryId = c.CategoryId", nativeQuery = true)
    List<Object> getBooksAndCategory();
}
