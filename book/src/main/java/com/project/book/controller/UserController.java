package com.project.book.controller;

import com.project.book.model.User;
import com.project.book.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping(path = "user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String Login (ModelMap modelMap){
        return "login";
    }
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String Login(ModelMap modelMap, @RequestParam("username") String username, String pass){
        int i = 0;
        i++;
        try {
            User u = userRepository.findUserByNameAndPassword(username, pass);
            if(u != null){
                return "redirect:/book/welcome";
            }
        }catch (Exception e){
            System.out.println(e);
        }
        modelMap.addAttribute("fail", "Login failed, pls try again");
        return "login";
    }


}
