package com.repositories;

import com.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> { //<Entity Type(kieu cua thuc the), primary key's type( khoa chinh)>
    List<Product> findbyProductName(String ProductName);    
}
