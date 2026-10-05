package com.example.UserAuthentication.DTOs;

import com.example.UserAuthentication.model.User;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDTO {
    private String userName;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String gender;

    public static User toEntity(UserDTO dto){
        User user = new User();

        user.setUserName(dto.getUserName());
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPhone(dto.getPhone());
        user.setAddress(dto.getAddress());
        user.setGender(dto.getGender());
        return user;
    }

    public static UserDTO toDTO(User user){
        UserDTO dto = new UserDTO();

        dto.setUserName(user.getUserName());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setPhone(user.getPhone());
        dto.setAddress(user.getAddress());
        dto.setGender(user.getGender());

        return dto;
    }

}
