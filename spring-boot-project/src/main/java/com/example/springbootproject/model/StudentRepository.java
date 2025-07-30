package com.example.springbootproject.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Student entities.
 * Provides CRUD operations and query methods for Student.
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}