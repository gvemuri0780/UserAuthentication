package com.example.UserAuthentication.DTOs;

import com.example.UserAuthentication.model.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RegistrationRequestDTO {
    private String id;
    @NotEmpty(message = "Username cannot be empty")
    private String userName;
    private String name;
    @NotEmpty(message = "Email can't be empty")
    @Email(message = "Invalid email format")
    private String email;
    @NotEmpty(message = "Phone cannot be empty")
    @Size(min = 10, max = 10, message = "phone number should be of 10 digits")
    private String phone;
    private String address;
    private String gender;
    @NotEmpty(message = "Password cannot be empty")
    private String password;

    public static User toEntity(RegistrationRequestDTO dto) {
        User user = new User();

        user.setUserName(dto.getUserName());
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPhone(dto.getPhone());
        user.setAddress(dto.getAddress());
        user.setGender(dto.getGender());
        user.setPassword(dto.getPassword());
        return user;
    }

    public static RegistrationRequestDTO toDTO(User user) {
        RegistrationRequestDTO dto = new RegistrationRequestDTO();

        dto.setUserName(user.getUserName());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setPhone(user.getPhone());
        dto.setAddress(user.getAddress());
        dto.setGender(user.getGender());
        dto.setPassword(user.getPassword());
        return dto;
    }
}
