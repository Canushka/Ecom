package com.example.Ecom.service;

import com.example.Ecom.dto.LoginDTO;
import com.example.Ecom.dto.UserDTO;
import com.example.Ecom.model.User;
import com.example.Ecom.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public String registerUser(UserDTO userDTO) {
        if (userRepository.existsById(userDTO.getEmail())) {
            return "User already exists!";
        }

        String encodedPassword = passwordEncoder.encode(userDTO.getPassword());
        User user = new User(userDTO.getEmail(), userDTO.getName(), encodedPassword);
        userRepository.save(user);
        return "User registered successfully!";
    }

    public String loginUser(LoginDTO loginDTO) {
        User user = userRepository.findById(loginDTO.getEmail()).orElse(null);

        if (user == null) {
            return "User not found!";
        }

        boolean passwordMatch = passwordEncoder.matches(loginDTO.getPassword(), user.getPassword());

        return passwordMatch ? "Login successful!" : "Invalid credentials!";
    }
}
