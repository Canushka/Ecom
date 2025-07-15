package com.example.Ecom.service;

import com.example.Ecom.model.User;
import com.example.Ecom.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    public User register(@org.jetbrains.annotations.NotNull User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("User already exists");
        }

        user.setPassword(encoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public boolean login(String email, String rawPassword) {
        User user = userRepository.findById(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return encoder.matches(rawPassword, user.getPassword());
    }
}
