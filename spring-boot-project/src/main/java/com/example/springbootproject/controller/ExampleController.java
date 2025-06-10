package com.example.springbootproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootproject.model.Student;
import com.example.springbootproject.service.StudentService;

@RestController
public class ExampleController {

    @Autowired
    private StudentService service;
    @GetMapping("/example")
    public List<Student> getExample() {
        // this is a simple GET endpoint
        System.out.println(" request received for /example"+service.getAllStudents().size());
        List<Student> students = service.getAllStudents();
        students.forEach(student -> {
            System.out.println("Student ID: " + student.getId());
            System.out.println("Student Name: " + student.getName());
            // System.out.println("Student Surname: " + student.getSurname());
            // System.out.println("Student Email: " + student.getEmail());
            // System.out.println("Student Passport Number: " + student.getPassportNumber());
        });

        return service.getAllStudents();
    }

    // @PostMapping(value="/example",produces = "application/json")
    // public Object postExample(@RequestBody String exampleData) {
    //     // this is simple post endpoint
    //     System.out.println("Received data: " + exampleData);
    //     return  exampleData;
    // }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return service.saveStudent(student);
    }

}