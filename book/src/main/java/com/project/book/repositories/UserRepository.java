package com.project.book.repositories;

import com.project.book.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {

    @Query(value = "SELECT * FROM users u WHERE u.Username = ?1 and u.Password = ?2", nativeQuery = true)
    User findUserByNameAndPassword(String username, String pass);
}
