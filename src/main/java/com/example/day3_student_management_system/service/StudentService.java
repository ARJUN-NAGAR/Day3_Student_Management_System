package com.example.day3_student_management_system.service;

import com.example.day3_student_management_system.model.StudentModel;
import com.example.day3_student_management_system.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

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

    // Display Students

    public List<StudentModel> getStudents(){
        return repository.findAll();
    }

    // delete

    public void deleteStudent(String id){ repository.deleteById(id);}


    // update
    public StudentModel updateStudent(String id,StudentModel student){
        StudentModel existingStudent=repository.findById(id)
        .orElseThrow(()->new RuntimeException("No Student found"));
        existingStudent.setName(student.getName());
        existingStudent.setAge(student.getAge());
        existingStudent.setEmail(student.getEmail());
        return repository.save(existingStudent);
    }

}
