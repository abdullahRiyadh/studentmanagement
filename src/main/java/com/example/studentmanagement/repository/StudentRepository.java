package com.example.studentmanagement.repository;


import com.example.studentmanagement.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface StudentRepository  extends JpaRepository<Student, Long> {

//    exact match
    List<Student> findByName(String name);

//    partial match
    List<Student>findByNameContainingIgnoreCase(String name);


}
