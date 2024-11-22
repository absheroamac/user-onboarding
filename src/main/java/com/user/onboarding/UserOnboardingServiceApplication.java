package com.user.onboarding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.user.onboarding.model.User;

@SpringBootApplication
public class UserOnboardingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserOnboardingServiceApplication.class, args);
		User user = new User();
		user.setEmail("null");
		user.setName("Name");
		user.setId("5");

		System.out.println(user.toString());
	}

}
