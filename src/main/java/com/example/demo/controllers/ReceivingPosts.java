package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.ApiResponse;

class MainUser {
    private int id;
    private String name;
    private String username;
    private String email;
    // getters and setters
    public MainUser() {}
    public MainUser(int id, String name, String username, String email) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
    } 
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getUserName() {return username;}
    public void setUserName(String username) {this.username = username;}

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
}
class MainUserSuccess extends MainUser {
    private String successMessage;

    //Constructors
    public MainUserSuccess() {}
    public MainUserSuccess(String successMessage, MainUser user) {
        super(user.getId(),user.getName(),user.getUserName(),user.getEmail());
        this.successMessage = successMessage;
    }

    public String getSuccessMessage() {return successMessage;}
    public void setSuccessMessage(String successMessage) {this.successMessage = successMessage;}
}
@RestController
@RequestMapping("/users/posts")
public class ReceivingPosts {
    private List<MainUser> userList = new ArrayList<>();

    @PostMapping("/add")
    public ApiResponse addToList(@RequestBody MainUser user1) {
        userList.add(user1);
        return new ApiResponse(true, "This worked");
    }

    @GetMapping("/view")
    public List<MainUser> getList() {
        return userList;    
    }

    @PutMapping("/update")
    public MainUserSuccess updateExistingUser(@RequestParam int id, @RequestBody MainUser updatedUser) {
        MainUser user = userList.stream()
                                .filter(x -> x.getId() == id)
                                .findAny()
                                .map(x -> {
                                    x.setId(updatedUser.getId());
                                    x.setName(updatedUser.getName());
                                    x.setUserName(updatedUser.getUserName());
                                    x.setEmail(updatedUser.getEmail());
                                    return x;
                                })
                                .orElse(null);
        if (user != null) {
            return new MainUserSuccess("Successfully updated user",user);
        }
        return null;
    }
}
