package com.user.onboarding.service;

import com.user.onboarding.model.User;

public class Service {

    public void verifyLombok(){
        User user = new User();
		user.setEmail("null");
		user.setName("Name");
		user.setId("5");

		System.out.println(user.toString());
    }
    
}
