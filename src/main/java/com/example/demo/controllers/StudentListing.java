package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.models.Student;

//Working with returning lists
// using ArrayList e.g List<String> test = new ArrayList<>();
// using Arrays.asList e.g List<String> test = Arrays.asList("John","Wan","Lem");
// using List.of - lists are immutable in this case e.g List<String> test = List.of("John","Wan","Lem");
@RestController
@RequestMapping("/lists")
public class StudentListing {
    @GetMapping("/students")
    public List<Student> getAllStudents() {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("John","Covenant University","300 Level"));
        studentList.add(new Student("Pogbe","Covenant University","200 Level"));
        studentList.add(new Student("Peter","UNILAG","100 Level"));
        return studentList;
    }
}
