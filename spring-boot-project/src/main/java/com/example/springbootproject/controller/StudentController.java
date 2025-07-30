package com.example.springbootproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootproject.model.Student;
import com.example.springbootproject.service.StudentService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;

/**
 * REST controller for managing Student entities.
 * Provides endpoints for CRUD operations on students.
 */
@RestController
public class StudentController {

    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentService service;

    /**
     * Retrieves all students.
     *
     * @return List of all students.
     */
    @GetMapping("/students")
    public List<Student> getAllStudents() {
        List<Student> students = service.getAllStudents();
        logger.info("Request received for /students, count: {}", students.size());
        students.forEach(student -> {
            logger.debug("Student ID: {}", student.getId());
            logger.debug("Student Name: {}", student.getName());
        });
        return students;
    }

    /**
     * Creates a new student.
     *
     * @param student Student object to create.
     * @return The created student.
     */
    @PostMapping(value = "/students", produces = "application/json")
    public ResponseEntity<Student> createStudent(@Validated @RequestBody Student student) {
        logger.info("Request received for /students with student: {}", student);
        if (student.getId() != null) {
            logger.warn("Student ID should not be provided for creation, received: {}", student.getId());
        }
        Student savedStudent = service.saveStudent(student);
        return ResponseEntity.ok(savedStudent);
    }

    /**
     * Deletes a student by ID.
     *
     * @param id ID of the student to delete.
     * @return No content response if successful, bad request if ID is null.
     */
    @DeleteMapping("/students/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        logger.info("Request received for deleting student with ID: {}", id);
        if (id == null) {
            logger.error("Student ID is null, cannot delete");
            return ResponseEntity.badRequest().build();
        }
        service.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Updates an existing student by ID.
     *
     * @param id      ID of the student to update.
     * @param student Updated student data.
     * @return The updated student, or bad request if input is invalid.
     */
    @PutMapping("/students/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @Validated @RequestBody Student student) {
        logger.info("Request received for updating student with ID: {}", id);
        if (id == null || student == null) {
            logger.error("Student ID or student data is null, cannot update");
            return ResponseEntity.badRequest().build();
        }
        Student updatedStudent = service.updateStudent(id, student);
        return ResponseEntity.ok(updatedStudent);
    }
}