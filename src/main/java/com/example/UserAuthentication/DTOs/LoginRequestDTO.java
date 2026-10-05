package com.example.UserAuthentication.DTOs;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LoginRequestDTO {
    @NotEmpty(message = "email cannot be empty!!")
    @Email(message = "email is not in format!!")
    private String email;
    @NotEmpty(message = "Password cannot be empty!!")
    private String password;
}
