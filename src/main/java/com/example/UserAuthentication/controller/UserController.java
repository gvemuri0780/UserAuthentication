package com.example.UserAuthentication.controller;

import com.example.UserAuthentication.DTOs.RegistrationRequestDTO;
import com.example.UserAuthentication.DTOs.UserDTO;
import com.example.UserAuthentication.model.User;
import com.example.UserAuthentication.services.UserRegistrationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.UserAuthentication.config.ApiResponse;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserRegistrationService userRegistrationService;
    @RequestMapping(value ="/register", method = RequestMethod.POST)
    public ResponseEntity<ApiResponse<UserDTO>> userRegistration(@Valid @RequestBody RegistrationRequestDTO requestDTO){
        UserDTO dto = userRegistrationService.registerUser(requestDTO);
        return ResponseEntity.ok(new ApiResponse<>(true, "User created successfully", dto));
    }

}
