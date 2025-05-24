package com.example.studentmanagement.model;

import  jakarta.persistence.*;

import javax.annotation.processing.Generated;
import java.time.LocalDate;


@Entity
@Table (name ="students")
public class Student {
    //fields/column

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;

    @Column(name="date_of_birth")
    private LocalDate dateOfBirth;




    //constructors
    public Student() {}

    public Student(String name, String email, LocalDate dateOfBirth) {
    this.name = name;
    this.email = email;
    this.dateOfBirth = dateOfBirth;
    }

    //getters and setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;

    }
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }




}
