package com.example.day3_student_management_system.repository;

import com.example.day3_student_management_system.model.StudentModel;
import com.example.day3_student_management_system.model.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<UserModel,String> {
    Optional<UserModel> findByEmail(String email);
}
