package com.example.day3_student_management_system.repository;

import com.example.day3_student_management_system.model.StudentModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends MongoRepository<StudentModel,String> {
}
