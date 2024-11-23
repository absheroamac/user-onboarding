package com.user.onboarding.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.user.onboarding.model.User;

public interface Repository extends MongoRepository<User,String>{
    
}
