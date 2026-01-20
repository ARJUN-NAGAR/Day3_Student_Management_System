package com.example.day3_student_management_system.controller;

import com.example.day3_student_management_system.model.StudentModel;
import com.example.day3_student_management_system.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    // Create function API
    // Get and post method in url purposes.

    @GetMapping("add-student/")
    public StudentModel addStudent(@RequestBody StudentModel student){
        return service.addStudent(student);
    }

}
