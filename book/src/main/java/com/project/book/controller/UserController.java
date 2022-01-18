package com.project.book.controller;

import com.project.book.model.User;
import com.project.book.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@RequestMapping(path = "user")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private HttpSession httpSession;

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String Login (ModelMap modelMap){
        int i = 0;
        i++;
        if(httpSession.getAttribute("username") != null){
            return "redirect:/book/booklist";
        }
        return "login";
    }
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String Login(ModelMap modelMap, @RequestParam("tennguoidung") String username, String pass){
        try {
            User u = userRepository.findUserByNameAndPassword(username, pass);
            if(u != null){
                httpSession.setAttribute("username", username);
                return "redirect:/book/welcome";
            }
        }catch (Exception e){
            System.out.println(e);
        }
        modelMap.addAttribute("fail", "Login failed, pls try again");
        return "login";
    }


}
