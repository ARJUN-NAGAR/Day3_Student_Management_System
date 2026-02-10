package com.example.day3_student_management_system.controller;

import com.example.day3_student_management_system.DTO.StudentRequestDTO;
import com.example.day3_student_management_system.DTO.StudentResponseDTO;
import com.example.day3_student_management_system.model.StudentModel;
import com.example.day3_student_management_system.service.StudentService;
import com.example.day3_student_management_system.util.JwtUtil;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
public class StudentController {

    private final StudentService service;
    private final JwtUtil jwtUtil;

    public StudentController(StudentService service,JwtUtil jwtUtil) {
        this.service = service;
        this.jwtUtil=jwtUtil;
    }

    private void checkToken(String authHeader){
        if(authHeader==null || !authHeader.startsWith("Bearer ")){
            throw new RuntimeException("Invalid token");
        }
        String token=authHeader.substring(7);
        jwtUtil.validateTokenAndGetEmail(token);
    }

    // Create function API
    // Get and post method in url purposes.

    @PostMapping("/add-student")
    public StudentResponseDTO addStudent(
            @RequestHeader("Authorization") String authHeader,
            @Valid @RequestBody StudentRequestDTO Student){

        checkToken(authHeader);
        return service.addStudent(Student);
    }

    @GetMapping("/students")
    public List<StudentResponseDTO> getStudents(
            @RequestHeader(value="Authorization", required=false) String authHeader){

        checkToken(authHeader);
        return service.getStudents();
    }
    /*@DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable String id){
        service.deleteStudent(id);
        return "Student Deleted Successfully";
    }
    @PutMapping("/update/{id}")
    public StudentResponseDTO updateStudent(@Valid @PathVariable String id, @Valid @RequestBody StudentRequestDTO student){
        return service.updateStudent(id,student);
    }
    // Add: PatchMapping for partial updates
    // Remove @Valid here to allow partial data
    @PatchMapping("/patch/{id}")
    public StudentResponseDTO patchStudent(@PathVariable String id, @RequestBody StudentRequestDTO student){
        return service.patchStudent(id, student);
    }
*/


    @PutMapping("/update/{id}")
    public StudentResponseDTO updateStudent(
            @RequestHeader("Authorization") String authHeader,
            @PathVariable String id,
            @Valid  @RequestBody StudentRequestDTO student){
        checkToken(authHeader);
        return service.updateStudent(id, student);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStudent(
            @RequestHeader("Authorization") String authHeader,
            @PathVariable String id){
        checkToken(authHeader);
        service.deleteStudent(id);
    }

}
