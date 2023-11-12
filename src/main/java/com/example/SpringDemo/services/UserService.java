package com.example.SpringDemo.services;

import com.example.SpringDemo.dto.SignInRequest;
import com.example.SpringDemo.dto.SignUpRequest;
import com.example.SpringDemo.dto.UpdateRequest;
import com.example.SpringDemo.models.Role;
import com.example.SpringDemo.models.User;
import com.example.SpringDemo.repositories.UserRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    
    public UserService(UserRepository userRepository) {
    	this.userRepository = userRepository;
    }
    
    public User signUp(SignUpRequest request) {
        var user = User
                .builder()
                .username(request.getUsername())
                .fullname(request.getFullname())
                .password(request.getPassword())
                .role(Role.user)
                .build();

        return userRepository.save(user);
    }
    
    public User signIn(SignInRequest request) throws Exception {
    	
        var user = getByUsername(request.getUsername());
        if(user.getPassword().equals(request.getPassword()))
        	return user;
        throw new Exception("Invalid password.");
    }

    public User create(User newUser) {
        return userRepository.save(newUser);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }
    
    public User getByUsername(String username) throws Exception {
        var user = userRepository
                .findByUsername(username);
        if(user == null)
        	throw new Exception("Invalid username.");
        return user;
    }
    
    public void deleteByUsername(String username) throws Exception {
        User user = getByUsername(username);
        userRepository.delete(user);
    }
    
    public void updateUser(UpdateRequest updatedUser) throws Exception {
        User user = getByUsername(updatedUser.getUsername());

        user.setPassword(updatedUser.getPassword());
        user.setFullname(updatedUser.getFullname());

        userRepository.save(user);
    }
}


