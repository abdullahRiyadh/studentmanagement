package com.example.studentmanagement.service;


import com.example.studentmanagement.model.Student;
import com.example.studentmanagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);

    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);

    }

    @Override
    public Student updateStudent(Long id, Student studentDetails)  {
        Optional<Student> studentOptional = studentRepository.findById(id);
        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            student.setName(studentDetails.getName());
            student.setEmail(studentDetails.getEmail());
            student.setDateOfBirth(studentDetails.getDateOfBirth());

            return studentRepository.save(student);
        }

        return null;

    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public List<Student> getStudentsByName(String name) {
        return studentRepository.findByName(name);
    }

    @Override
    public List<Student> searchStudentByName(String name) {
        return studentRepository.findByNameContainingIgnoreCase(name);
    }

    //exact
    @Override
    public Optional<Student> getStudentByExactEmail(String email) {
        return studentRepository.findByExactEmail(email);
    }


    //partial
    @Override
    public List<Student> getStudentByEmail(String email) {
        return studentRepository.findByEmail(email);
    }

    @Override
    public Page<Student> getStudentByPage(int page, int size) {
        Pageable pageable =PageRequest.of(page, size);
        return studentRepository.findAllByNative(pageable);
    }


}

