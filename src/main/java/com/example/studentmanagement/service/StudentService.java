package com.example.studentmanagement.service;

import com.example.studentmanagement.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    Student saveStudent(Student student);
    List<Student> getAllStudents();
    Student getStudentById(Long id);
    Student updateStudent(Long id, Student student);
    void deleteStudent(Long id);
    List<Student> getStudentsByName(String name); //exact
    List<Student> searchStudentByName(String studentName); //partial

    //
     //Optional for one exact match
    Optional<Student>getStudentByExactEmail(String email);


    //partial
    List<Student>getStudentByEmail(String email);
}
