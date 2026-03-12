package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.ApiResponse;

class MainUser {
    private int id;
    private String name;
    private String username;
    private String email;
    // getters and setters
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getUserName() {return username;}
    public void setUserName(String username) {this.username = username;}

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
}
@RestController
@RequestMapping("/users/posts")
public class ReceivingPosts {
    List<MainUser> userList = new ArrayList<>();

    @PostMapping("/add")
    public ApiResponse addToList(@RequestBody MainUser user1) {
        userList.add(user1);
        return new ApiResponse(true, "This worked");
    }

    @GetMapping("/view")
    public List<MainUser> getList() {
        return userList;    
    }
}
