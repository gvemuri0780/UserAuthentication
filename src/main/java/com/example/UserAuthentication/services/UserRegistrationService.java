package com.example.UserAuthentication.services;

import com.example.UserAuthentication.DTOs.RegistrationRequestDTO;
import com.example.UserAuthentication.DTOs.UserDTO;
import com.example.UserAuthentication.customExceptions.UserEmailExistsException;
import com.example.UserAuthentication.model.User;
import com.example.UserAuthentication.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserRegistrationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserDTO registerUser(RegistrationRequestDTO requestDTO){
        if(userRepository.existsByEmail(requestDTO.getEmail()))
            throw new UserEmailExistsException("User with this email already exists");
        requestDTO.setPassword(passwordEncoder.encode(requestDTO.getPassword()));
        User user = RegistrationRequestDTO.toEntity(requestDTO);
        User savedUser = userRepository.save(user);
        return UserDTO.toDTO(savedUser);
    }
}
