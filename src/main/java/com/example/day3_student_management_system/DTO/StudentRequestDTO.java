package com.example.day3_student_management_system.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class StudentRequestDTO {

        @NotBlank(message="Name can not be blank")
        private String name;

        @Min(value=5,message="Age can't be less than 5")
        @Max(value=90,message="Age can't be more than 90")
        private int age;

        @Email(message="Email should be valid")
        @NotBlank(message="Email can not be blank")
        private String email;

}