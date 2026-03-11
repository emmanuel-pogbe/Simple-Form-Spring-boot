package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.User;

@Controller
@RequestMapping
public class Frontend {
    @GetMapping(value = "/")
    public String homePage() {
        return "index";
    }
    // Learning how to get Form data

    // Using RequestParam
    @PostMapping("/")
    public String handleForm(
        @RequestParam("email") String email,
        @RequestParam("password") String password,
        Model model
    )  {
        if (email.equals("pogbe@gmail.com") && password.equals("12345")) {
            return "success";
        }
        model.addAttribute("isLoggedIn", false);
        return "index";
    }







    // Using @ModelAttribute
    // @PostMapping(value = "/")
    // public String getForm(
    //     @ModelAttribute User user,
    //     Model model
    // ) {
    //     String email = user.getEmail();
    //     String password = user.getPassword();
    //     if ("pogbe@gmail.com".equals(email) && "12345".equals(password)){
    //         model.addAttribute("email",email);
    //         return "success";
    //     }
    //     model.addAttribute("isLoggedIn", false);
    //     return "index";
    // }
}
