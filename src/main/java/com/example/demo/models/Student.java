package com.example.demo.models;

import java.io.Serializable;

public class Student implements Serializable {
    private String student_name;
    private String student_school;
    private String student_class;

    public Student() {} // Non-parameterized constructor

    public Student(String student_name, String student_school, String student_class) {
        this.student_name = student_name;
        this.student_school = student_school;
        this.student_class = student_class;
    }
    //Getters and setters
    public String getStudentName() {return this.student_name;}
    public void setStudentName(String student_name) {this.student_name = student_name;}

    public String getStudentSchool() {return this.student_school;}
    public void setStudentSchool(String student_school) {this.student_school = student_school;}
    
    public String getStudentClass() {return this.student_class;}
    public void setStudentClass(String student_class) {this.student_class = student_class;}   
}
