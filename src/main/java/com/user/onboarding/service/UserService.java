package com.user.onboarding.service;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.user.onboarding.model.User;
import com.user.onboarding.repository.Repository;

@Service
public class UserService {

    private final Repository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(Repository userRepository,BCryptPasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<User> getAllUsers() {                                                                                                                                                                  
        return userRepository.findAll();
    }

    public Boolean login(String email, String password){

        return userRepository.findByEmail(email).map(user->passwordEncoder.matches(password, user.getPassword())).orElse(false);

    }

    public String register(User user) {
        //check whetehr already there or not
        if(userRepository.findByEmail(user.getEmail()).isPresent()){
            return "Already registered";
        }
        else{
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);

            return "Successfully Registered";
            
        }
        
    }
    
}
