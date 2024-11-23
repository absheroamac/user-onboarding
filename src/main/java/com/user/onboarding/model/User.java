package com.user.onboarding.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Document("users")
public class User {
    @Id
    private String id;
    private String name;
    private String email;
}
