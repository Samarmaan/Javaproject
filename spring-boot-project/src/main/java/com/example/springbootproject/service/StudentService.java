package com.example.springbootproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbootproject.model.Student;
import com.example.springbootproject.model.StudentRepository;

/**
 * Service class for managing Student entities.
 * Provides business logic for CRUD operations on students.
 */
@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    /**
     * Retrieves all students from the repository.
     *
     * @return List of all students.
     */
    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    /**
     * Saves a new student to the repository.
     *
     * @param student Student object to save.
     * @return The saved student.
     */
    public Student saveStudent(Student student) {
        return repository.save(student);
    }

    /**
     * Updates an existing student by ID.
     *
     * @param id             ID of the student to update.
     * @param updatedStudent Student object containing updated data.
     * @return The updated student, or null if not found.
     */
    public Student updateStudent(Long id, Student updatedStudent) {
        return repository.findById(id).map(student -> {
            student.setName(updatedStudent.getName());
            student.setEmail(updatedStudent.getEmail());
            student.setSurname(updatedStudent.getSurname());
            student.setPassportNumber(updatedStudent.getPassportNumber());
            return repository.save(student);
        }).orElse(null);
    }

    /**
     * Deletes a student by ID.
     *
     * @param id ID of the student to delete.
     */
    public void deleteStudent(Long id) {
        repository.deleteById(id);
    }
}