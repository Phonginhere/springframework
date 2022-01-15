package com.example.demo.controllers;

import com.example.demo.models.Category;
import com.example.demo.models.Product;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

@Controller //not RestController
@RequestMapping(path = "category")
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;//DI = Dependency Injection
    @Autowired
    private ProductRepository productRepository;//DI = Dependency Injection
    @Autowired
    private ProductController productController;

    //http://localhost:8080/category
    @RequestMapping(value = "", method = RequestMethod.GET)
    //return name of jsp file, like "return View();" of .NET MVC
    public String getAllCategories(ModelMap modelMap) {
        //modelMap = ViewBag, ViewData
        modelMap.addAttribute("x", "123467788");
        Iterable<Category> categories = categoryRepository.findAll();
        modelMap.addAttribute("categories", categories);
        return "category"; //find view with name "category.jsp"
    }

    @RequestMapping(value = "/updateCustomerContacts", method = RequestMethod.POST)
    public String updateCustomerContacts(ModelMap modelMap, @RequestParam("idProduct") String idProduct, String idCate) {
        try{
            Optional<Product> p = productRepository.findById(idProduct);
            if(p.isPresent() && idCate != null){
                Product selectedProduct = p.get();
                selectedProduct.setCategoryID(idCate);
                productRepository.save(selectedProduct);
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return "redirect:/product/getProductByCategoryID/"+idCate;
    }


}
