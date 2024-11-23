package com.user.onboarding.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.user.onboarding.model.User;
import com.user.onboarding.repository.Repository;

@Service
public class UserService {

    private final Repository userRepository;

    public UserService(Repository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return List.of(new User("John Doe", "john@example.com","5"));
        // return userRepository.findAll();
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }
    
}
