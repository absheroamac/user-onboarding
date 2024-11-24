package com.user.onboarding.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.user.onboarding.model.User;
import com.user.onboarding.service.UserService;
import com.user.onboarding.util.JwtUtil;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    // Constructor injection for JwtUtil
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        String response = userService.register(user);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestParam String email, @RequestParam String password) {
        Boolean isValid = userService.login(email, password);
        if (isValid) {
            // Generate token using JwtUtil
            String token = JwtUtil.generateToken(email);  // Ensure JwtUtil is used for token generation
            return ResponseEntity.ok(token);
        } else {
            // Return 401 Unauthorized status with error message
            return ResponseEntity.status(401).body("Invalid Email or Password");
        }
    }

    @RequestMapping("/error")
    public String handleError() {
        return "error-page"; // Return a custom error page view
    }
}
