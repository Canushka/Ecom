package com.example.Ecom.controller;

import com.example.Ecom.dto.LoginDTO;
import com.example.Ecom.dto.UserDTO;
import com.example.Ecom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String register(@RequestBody UserDTO userDTO) {
        return userService.registerUser(userDTO);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginDTO loginDTO) {
        return userService.loginUser(loginDTO);
    }
}
