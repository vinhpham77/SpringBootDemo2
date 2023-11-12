package com.example.SpringDemo.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;
import java.util.List;

@Data
@Builder
@Document(collection = "user")
public class User {
    @Id
    private String id;
    
    @Indexed(unique = true)
    private String username;
    
    @NonNull
    private String password;
    
    @NonNull
    private Role role;
    private String fullname;
    
}
