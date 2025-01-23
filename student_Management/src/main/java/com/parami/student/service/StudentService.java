package com.parami.student.service;

import com.parami.student.entity.Student;

import java.util.List;

public interface StudentService {

    // Get all students
    List<Student> findAll();

    // Get student by ID
    Student findById(Long theId);

    // Save or update a student
    Student save(Student theStudent);

    // Delete student by ID
    void deleteById(Long theId);
}
