package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Student;

@RestController
@RequestMapping("/page")
public class DynamicURLs {
    private List<Student> studentList = Arrays.asList(
        new Student("John","Covenant University","300 Level"),
        new Student("Pogbe","Covenant University","200 Level"),
        new Student("Peter","UNILAG","100 Level")
    );


    @GetMapping("/{university}")
    public List<Student> getStudent(@PathVariable("university") String university) {
        List<Student> result = new ArrayList<>();
        result = studentList.stream()
                    .filter(p -> p.getStudentSchool().equals(university))
                    .collect(Collectors.toList());
        return result;
    }
}
