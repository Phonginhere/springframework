package com.example.demo.controllers;

import com.example.demo.models.Category;
import com.example.demo.models.Product;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "product")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @RequestMapping(value = "/getProductByCategoryID/{categoryID}", method = RequestMethod.GET)
    //http:localhost:8080/product/getProductByCategoryID/C0103
    public String getProductByCategoryID(ModelMap modelMap, @PathVariable String categoryID) {
        int i = 0;
        i++;
        Iterable<Product> products = productRepository.findByCategoryID(categoryID);
        modelMap.addAttribute("products", products);
        return "productlist"; //productlist.jsp
    }

    @RequestMapping(value = "/assignProductToCategoryID/{productID}", method = RequestMethod.GET)
    //http:localhost:8080/product/assignProductToCategoryID/P0103
    public String assignProductToCategoryID(ModelMap modelMap, @PathVariable String productID) {
        int i = 0;
        i++;
        Iterable<Category> categories = categoryRepository.findAll();
        modelMap.addAttribute("categories", categories);


        Optional<Product> pne = productRepository.findById(productID);
        String productName = pne.orElseThrow(RuntimeException::new).getProductName();
        modelMap.addAttribute("nameProduct", productName);
        modelMap.addAttribute("idProduct", productID);

        return "assign"; //assign.jsp
    }


}
