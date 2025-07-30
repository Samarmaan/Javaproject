package com.example.springbootproject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

/**
 * Entity representing a student.
 * Contains basic student information such as name, surname, email, and passport number.
 */
@Entity
public class Student {

    /**
     * Unique identifier for the student.
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * First name of the student.
     */
    private String name;

    /**
     * Surname of the student.
     */
    private String surname;

    /**
     * Email address of the student.
     */
    private String email;

    /**
     * Passport number of the student.
     */
    private Long passportNumber;

    /**
     * Default constructor required by JPA.
     */
    public Student() {}

    /**
     * Parameterized constructor for convenience.
     *
     * @param name          First name of the student.
     * @param surname       Surname of the student.
     * @param email         Email address of the student.
     * @param passportNumber Passport number of the student.
     */
    public Student(String name, String surname, String email, Long passportNumber) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.passportNumber = passportNumber;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(Long passportNumber) {
        this.passportNumber = passportNumber;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", passportNumber=" + passportNumber +
                '}';
    }
}