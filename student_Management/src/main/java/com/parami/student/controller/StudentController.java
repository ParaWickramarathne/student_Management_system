package com.parami.student.controller;

import java.util.List;

import com.parami.student.entity.Student;
import com.parami.student.service.StudentService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    // Constructor injection for the student service
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // Mapping for the "/list" endpoint
    @GetMapping("/list")
    public String listStudents(Model model) {

        // Get all students from the service
        List<Student> students = studentService.findAll();

        // Add the students list to the model
        model.addAttribute("students", students);

        // Return the view for the students list
        return "students/list-students";
    }

    // Mapping for showing the form to add a new student
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        // Create a new student object
        Student student = new Student();

        // Add the new student object to the model to bind form data
        model.addAttribute("student", student);

        // Return the form view for adding a student
        return "students/student-form";
    }

    // Mapping for showing the form to update an existing student
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("studentId") Long studentId, Model model) {
        // Get the student from the service using the ID
        Student student = studentService.findById(studentId);

        // Add the student to the model to pre-populate the form
        model.addAttribute("student", student);

        // Return the form view for updating the student
        return "students/student-form";
    }

    // Mapping for saving a student (either new or updated)
    @PostMapping("/save")
    public String saveStudent(@ModelAttribute("student") Student student) {
        // Save the student using the service
        studentService.save(student);

        // Redirect to the list of students to prevent duplicate submissions
        return "redirect:/students/list";
    }

    // Mapping for deleting a student
    @GetMapping("/delete")
    public String deleteStudent(@RequestParam("studentId") Long studentId) {
        // Delete the student by ID using the service
        studentService.deleteById(studentId);

        // Redirect to the list of students
        return "redirect:/students/list";
    }
}
