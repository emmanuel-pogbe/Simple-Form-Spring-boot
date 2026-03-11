package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
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
    // Learning how to get Post data
    @PostMapping(value = "/api/message")
    public String message(
        @RequestParam("name") String userName,
        @RequestParam("email") String userEmail
    ) {
        System.out.println("\n\n\n");
        System.out.println("User typed name: "+userName);
        System.out.println("User typed email: "+userEmail);
        System.out.println("\n\n");
        return "success";
    }
}
