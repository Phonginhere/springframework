package com.project.book.controller;

import com.project.book.model.Book;
import com.project.book.model.Category;
import com.project.book.repositories.BookRepository;
import com.project.book.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping(path = "book")
public class BookController {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private CategoryRepository categoryRepository;


    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String Welcome (ModelMap modelMap){
        return "welcome";
    }

    @RequestMapping(value = "/booklist", method = RequestMethod.GET)
    public String BookList (ModelMap modelMap){

        Iterable<Book> books = bookRepository.findAll();
        for(Book b:books){
            System.out.println(b);
        }
        modelMap.addAttribute("books", books);
        return "booklist";
    }

    @RequestMapping(value = "/bookDeleteConfirm", method = RequestMethod.GET)
    public String BookDeleteConfirm (ModelMap modelMap,@RequestParam("bookId") String bookId){

        modelMap.addAttribute("bookid", bookId);
        return "ask";
    }

    @RequestMapping(value = "/BookDelete", method = RequestMethod.POST)
    public String BookDelete (ModelMap modelMap, String bookId){

        try{
            Optional<Book> b =bookRepository.findById(bookId);
            if(b.isPresent()){
                Book selectedbook = b.get();
                bookRepository.delete(selectedbook);
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return "redirect:/book/booklist";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.GET)
    public String Insert (ModelMap modelMap){

        Iterable<Category> categories = categoryRepository.findAll();
        modelMap.addAttribute("categories", categories);
        return "insertbook";
    }

    @RequestMapping(value = "/insertconfirmed", method = RequestMethod.POST)
    public String AcceptToInsert (ModelMap modelMap, String title, String idCate, String price){

        try{
            Book b = new Book(title, idCate, Float.parseFloat(price));
            bookRepository.save(b);
        }catch (Exception e){
            System.out.println(e);
        }
        return "redirect:/book/booklist";
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String Logout(ModelMap modelMap){
        return "redirect:/user/login";
    }
}
