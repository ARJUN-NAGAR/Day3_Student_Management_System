package com.example.day3_student_management_system.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequestDto {
    @NotBlank(message="Email is required")
    @Email(message="Email should be valid")
    private String email;
    @NotBlank(message="Password is required")
    @Size(min=6,message="Password must be at least of 6 character")
    private String password;

}
