package com.example.springbootproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main class for starting the Spring Boot application.
 * This class bootstraps the application using Spring Boot's auto-configuration.
 */
@SpringBootApplication
public class SpringBootProjectApplication {

    /**
     * Main method to launch the Spring Boot application.
     *
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        SpringApplication.run(SpringBootProjectApplication.class, args);
    }
}