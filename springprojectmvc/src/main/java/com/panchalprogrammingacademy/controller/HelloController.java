package com.panchalprogrammingacademy.controller;

import com.panchalprogrammingacademy.model.Category;
import com.panchalprogrammingacademy.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.management.Query;
import java.util.List;

@Controller
@RequestMapping("category")
public class HelloController {

//    @RequestMapping(value = "/helloWorld", method = RequestMethod.GET)
//    public String printHelloWorld(ModelMap modelMap){
//
//        // add attribute to load modelMap
//        modelMap.addAttribute("message",
//                "Hello World and Welcome to Spring MVC!");
//
//        // return the name of the file to be loaded "hello_world.jsp"
//        return "hello_world";
//    }

    @Autowired
    private ICategoryService iCategoryService;

    @RequestMapping(value = "/listcate")
    public String sayHello(Model model){
          List<Category> categories =  iCategoryService.findAll();
            model.addAttribute("listCategories",categories);
            return "index";
    }

}
