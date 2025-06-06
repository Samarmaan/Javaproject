package com.example.springbootproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {

    @GetMapping("/example")
    public String getExample() {
        // this is a simple GET endpoint
        return "Hello, this is an example response!";
    }

    @PostMapping(value="/example",produces = "application/json")
    public Object postExample(@RequestBody String exampleData) {
        System.out.println("Received data: " + exampleData);
        return  exampleData;
    }
}