package com.example.SpringDemo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.SpringDemo.models.User;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String>{
    User findByUsername(String username);
}
