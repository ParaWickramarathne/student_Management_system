package com.parami.student.repository;

import com.parami.student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    // No need to write any implementation code, Spring Data JPA handles it for us.

    // Add a method to sort students by their first name or any other field

    // public List<Student> findAllByOrderByFirstNameAsc();

    // You can sort by first name in ascending order

}
