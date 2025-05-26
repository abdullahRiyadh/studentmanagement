package com.example.studentmanagement.repository;


import com.example.studentmanagement.model.Student;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository

public interface StudentRepository  extends JpaRepository<Student, Long> {

//    exact match
    List<Student> findByName(String name);

//    partial match
    List<Student>findByNameContainingIgnoreCase(String name);



    //exact
    //Optional for one exact match
    @Query(value="SELECT * FROM students WHERE email=:email",nativeQuery = true)
    Optional<Student>findByExactEmail(@Param("email") String email);

    //partial
    @Query(value = "SELECT * FROM students WHERE LOWER(email) LIKE LOWER(CONCAT('%', :email, '%'))",nativeQuery = true)
    List<Student> findByEmail(@Param("email") String email);

    @Query(value = "SELECT * FROM students",
            countQuery = "SELECT COUNT(*) FROM students",
            nativeQuery = true)
    Page<Student> findAllByNative(Pageable pageable);




}
