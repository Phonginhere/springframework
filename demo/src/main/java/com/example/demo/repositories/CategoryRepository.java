package com.example.demo.repositories;

import com.example.demo.models.Category;
import com.example.demo.models.Product;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, String> {
//    List<Category> findByName(String name);

    @Query(value = "SELECT * FROM categories", nativeQuery = true)
    List<Category> findAllCategory();
    List<Category> findByCategoryID(String categoryID);

    @Modifying
    @Query(value = "UPDATE products u SET u.CategoryID = :id WHERE u.ProductName = :name", nativeQuery = true)
    void updateProduct(@Param(value = "name") String name, @Param(value = "id") String id);


}
