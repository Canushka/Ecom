package com.example.Ecom.controller;

import com.example.Ecom.model.User;
import com.example.Ecom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public String register(@RequestBody User user) {
        userService.register(user);
        return "Signup successful!";
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        boolean success = userService.login(user.getEmail(), user.getPassword());
        return success ? "Login successful!" : "Invalid email or password";
    }
}
