package com.example.demo.controllers;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.User;
import com.example.demo.models.Student;


@RestController
@RequestMapping("/rest")
public class JSONController {
    @ResponseBody
    @GetMapping(path = "/health",produces = "application/json")
    public Map<String,String> health() {
        return Map.of("status","healthy");
    }

    @GetMapping(path="/student",produces = "application/json")
    public Student getStudent() {
        Student student = new Student("John","Covenant","200 Level");
        return student;
    }
}
