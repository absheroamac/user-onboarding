package com.user.onboarding.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.onboarding.model.User;
import com.user.onboarding.service.UserService;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

     @PostMapping("/add")
     public ResponseEntity<User> addUser(@RequestBody User user){
        User newUser = userService.addUser(user);
        return ResponseEntity.ok(newUser);
     }

    @GetMapping
    public List<User> getUsers(){
        return userService.getAllUsers();
    }

    @RequestMapping("/error")
    public String handleError() {
        return "error-page"; // Return a custom error page view
    }
    
}
