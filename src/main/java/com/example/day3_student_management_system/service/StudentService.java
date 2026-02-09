package com.example.day3_student_management_system.service;

import com.example.day3_student_management_system.DTO.StudentRequestDTO;
import com.example.day3_student_management_system.DTO.StudentResponseDTO;
import com.example.day3_student_management_system.exception.StudentNotFoundException;
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

    /*public StudentModel addStudent(StudentModel student){
        return repository.save(student);
    }*/

    public StudentResponseDTO addStudent(StudentRequestDTO dto){
        StudentModel Student=new StudentModel();
        Student.setName(dto.getName());
        Student.setAge(dto.getAge());
        Student.setEmail(dto.getEmail());
        StudentModel saved=repository.save(Student);
        return new StudentResponseDTO(
                saved.getId(),
                saved.getName(),
                saved.getAge(),
                saved.getEmail()
        );
    }

    // Display Students

    /*public List<StudentModel> getStudents(){
        return repository.findAll();
    }*/

    public List<StudentResponseDTO> getStudents(){
        return repository.findAll()
                .stream()
                .map( s -> new StudentResponseDTO(
                        s.getId(),
                        s.getName(),
                        s.getAge(),
                        s.getEmail()
                )).toList();
    }

    // delete

   /* public void deleteStudent(String id){ repository.deleteById(id);}*/
   public void deleteStudent(String id){
       if(!repository.existsById(id)){
           throw new StudentNotFoundException("Student does not exist yet");
       }
       repository.deleteById(id);}


    // update
    /*public StudentModel updateStudent(String id,StudentModel student){
        StudentModel existingStudent=repository.findById(id)
        .orElseThrow(()->new RuntimeException("No Student found"));
        existingStudent.setName(student.getName());
        existingStudent.setAge(student.getAge());
        existingStudent.setEmail(student.getEmail());
        return repository.save(existingStudent);
    }*/
    public StudentResponseDTO updateStudent(String id,StudentRequestDTO dto){
        StudentModel existingStudent=repository.findById(id)
                .orElseThrow(()->new StudentNotFoundException("Student does not exist yet"));
        existingStudent.setName(dto.getName());
        existingStudent.setAge(dto.getAge());
        existingStudent.setEmail(dto.getEmail());
        StudentModel update=repository.save(existingStudent);
        return new StudentResponseDTO(
                update.getId(),
                update.getName(),
                update.getAge(),
                update.getEmail()
        );
    }

    public StudentResponseDTO patchStudent(String id, StudentRequestDTO dto) {
        StudentModel existing = repository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with id: " + id));

        // Only update fields that are provided (not null/zero)
        if (dto.getName() != null && !dto.getName().isBlank()) {
            existing.setName(dto.getName());
        }
        if (dto.getAge() > 0) { // Assuming age 0 or less is "not provided"
            existing.setAge(dto.getAge());
        }
        if (dto.getEmail() != null && !dto.getEmail().isBlank()) {
            existing.setEmail(dto.getEmail());
        }

        StudentModel updated = repository.save(existing);
        return new StudentResponseDTO(
                updated.getId(),
                updated.getName(),
                updated.getAge(),
                updated.getEmail()
        );
    }

}
