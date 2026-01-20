package com.example.day3_student_management_system.service;

import com.example.day3_student_management_system.model.StudentModel;
import com.example.day3_student_management_system.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private StudentRepository repository;
    public StudentService(StudentRepository repository){
        this.repository=repository;
    }

    // Create

    public StudentModel addStudent(StudentModel student){
        return repository.save(student);
    }
    //

}
