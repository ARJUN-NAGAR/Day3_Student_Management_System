package com.example.day3_student_management_system.controller;

import com.example.day3_student_management_system.DTO.StudentRequestDTO;
import com.example.day3_student_management_system.DTO.StudentResponseDTO;
import com.example.day3_student_management_system.model.StudentModel;
import com.example.day3_student_management_system.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    // Create function API
    // Get and post method in url purposes.

    @GetMapping("add-student/")
    public StudentResponseDTO addStudent(@Valid @RequestBody StudentRequestDTO Student){
        return service.addStudent(Student);
    }
    @GetMapping("/students")
    public List<StudentResponseDTO> getStudents(){
        return service.getStudents();
    }
    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable String id){
        service.deleteStudent(id);
        return "Student Deleted Successfully";
    }
    @PutMapping("/update/{id}")
    public StudentResponseDTO updateStudent(@PathVariable String id,@RequestBody StudentRequestDTO student){
        return service.updateStudent(id,student);
    }

}
