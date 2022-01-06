package com.controllers;

import com.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path= "/api/v1/Products")
public class ProductController {
    @GetMapping("")
    public String simpleRequest(){
        return "very simple";
    }
    //another request
    @GetMapping("/dosth")
    public List<String> doSth(){
        List<String> response = new ArrayList<>();
        response.add("1");
        response.add("a");
        response.add("&");
        return response;
    }
    //begin error
    //another request 2.0
    //http://localhost:8080/api/v1/Products/apiProducts
    @GetMapping("/apiProducts")
    public List<Product> products(){
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Product A", 2012, 100.000, "thephongblog.tk"));
        products.add(new Product(2, "Product B", 2015, 132.000, "thephongblog.tk/hello"));
        products.add(new Product(3, "Product C", 2019, 89.0, "thephongblog.tk/blog_details/2"));
        return products;
    }
}
