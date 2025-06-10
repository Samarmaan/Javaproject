package com.example.springbootproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbootproject.model.Student;
import com.example.springbootproject.model.StudentRepository;

@Service
public class StudentService {
    @Autowired
    private StudentRepository repository;

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public Student saveStudent(Student student) {
        return repository.save(student);
    }

    public void deleteStudent(Long id) {
        repository.deleteById(id);
    }
}

