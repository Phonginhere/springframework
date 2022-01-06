package com.controller;

import com.models.Product;
import com.models.ResponseObject;
import com.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController //annotation de bao cho thg java scirpt la cai class nay la controller
@RequestMapping(path = "/api/v1/Products") //dinh tuyen, dinh huong
public class ProductController {
    @GetMapping("/getallproductstest") //this request is: http://localhost:8080/api/v1/Products/getallproductstest
    List<String> getAllProductsTest(){
        return List.of("iphone", "ipad");
    }
    @Autowired
    private ProductRepository repository; //khi de auto write, doi tuong repository se duoc tao ra ngay khi add vao. giong singleton pattern trong java

    @GetMapping("")
    //this request is: http://localhost:8080/api/v1/Products
    List<Product> getAllProducts(){
        return repository.findAll(); //find all data
    }
    @GetMapping("/{id}")  //http://localhost:8080/api/v1/Products/1
    //return an object with: data, message, status
    ResponseEntity<ResponseObject> findbyId(@PathVariable Integer id){
        Optional<Product> foundProduct = repository.findById(id);
        if(foundProduct.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "Query product succesfully", foundProduct)

            );
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseObject("false", "Cannot find product with id= "+id, ""));
        }
    }

    //insert new Product with POST method
    //Postman: Raw, Json
    @PostMapping("/insert")
    ResponseEntity<ResponseObject> insertProduct(@RequestBody Product newProduct){
        //2 product must not the same name
//        List<Product> foundProducts = repository.findbyProductName(newProduct.getProductName().trim());
//        if(foundProducts.size() > 0){
//            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
//                    new ResponseObject("failed", "insert product duplicated= ", ""));
//        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("Ok", "insert product succesfully", repository.save(newProduct)));
    }

    //update if found
    @PutMapping("/{id}")
    ResponseEntity<ResponseObject> updateProduct(@RequestBody Product newProduct, @PathVariable Integer id) {
        Optional<Product> foundProduct = repository.findById(id);
        if(foundProduct.isPresent()){
            Optional<Object> updateProduct = repository.findById(id).map(
                    product -> {
                        product.setProductName(newProduct.getProductName());
                        product.setYear(newProduct.getYear());
                        product.setPrice(newProduct.getPrice());
                        product.setUrl(newProduct.getUrl());
                        return repository.save(product);
                    });
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("Ok", "update product succesfully", updateProduct));
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseObject("failed", "Cannot find product with id= "+id, ""));
        }
    }
    @DeleteMapping("/{id}")
    ResponseEntity<ResponseObject> deleteProduct(@PathVariable Integer id){
        boolean exists = repository.existsById(id);
        if(exists){ //neu ton tai
            repository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "Delete Product Succesfully", "")
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("failed", "Cannot find product to delete", "")
        );
    }
}
