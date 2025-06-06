package com.example.studentmanagement.controller;


import com.example.studentmanagement.model.Student;
import com.example.studentmanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/students")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;

    }
    @PostMapping
    public Student createStudent(@RequestBody Student student) {

        return studentService.saveStudent(student);

    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();

    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);

    }
    @PutMapping("{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
        return studentService.updateStudent(id, student);
    }


    @DeleteMapping("{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }

    @GetMapping("name/{name}")
    public List<Student> getStudentByName(@PathVariable String name) {
        return studentService.getStudentsByName(name);

    }

    @GetMapping("/search")
    public List<Student> searchStudentByName(@RequestParam String name) {
        return studentService.searchStudentByName(name);
    }

    //exact
    @GetMapping("email")
    public Optional<Student> findStudentByEmail(@RequestParam String email) {
        return studentService.getStudentByExactEmail(email);
    }


    //partial
    @GetMapping("/emailsearch")
    public List<Student> getStudentByEmail(@RequestParam String email) {
        return studentService.getStudentByEmail(email);
    }


    @GetMapping("/paginated")
    public Page<Student> getStudentByPage(@RequestParam int page, @RequestParam int size) {
        return studentService.getStudentByPage(page, size);
    }


}
