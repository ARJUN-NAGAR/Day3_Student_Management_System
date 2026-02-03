package com.example.day3_student_management_system.exception;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(String message) {
        super(message);
    }      // eror 404 runtime exception
}
