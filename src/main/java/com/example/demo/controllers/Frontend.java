package com.example.demo.controllers;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.User;

@Controller
@RequestMapping
public class Frontend {
    @GetMapping(value = "/")
    public String homePage() {
        return "index";
    }

    @GetMapping(value = "/success")
    public String successPage(@RequestParam("email") String email, Model model) {
        model.addAttribute("email", email);
        return "success";
    }
    // Learning how to get Form data
    // Working with JSON data from Client
    @PostMapping(value = "/", consumes = "application/json")
    @ResponseBody
    public Map<String, Object> handleForm(@RequestBody User user) {
        String email = user.getEmail();
        String password  = user.getPassword();
        if (email.equals("pogbe@gmail.com") && password.equals("12345")) {
            return Map.of("isLoggedIn",true);
        }
        return Map.of("isLoggedIn",false);
    }
    
    
    // Using RequestParam for Form data
    // @PostMapping("/")
    // public String handleForm(
    //     @RequestParam("email") String email,
    //     @RequestParam("password") String password,
    //     Model model
    // )  {
    //     if (email.equals("pogbe@gmail.com") && password.equals("12345")) {
    //         return "success";
    //     }
    //     model.addAttribute("isLoggedIn", false);
    //     return "index";
    // }

    
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
