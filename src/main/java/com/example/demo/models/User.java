package com.example.demo.models;

import java.io.Serializable;

// JavaBean
public class User implements Serializable{
    private String email;
    private String password;
    
    //Getters and Setters
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
