package com.example.SpringDemo.controllers;

import com.example.SpringDemo.dto.SignInRequest;
import com.example.SpringDemo.dto.SignUpRequest;
import com.example.SpringDemo.dto.UpdateRequest;
import com.example.SpringDemo.models.User;
import com.example.SpringDemo.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/users")
public class UserController {
    private final UserService userService;
    
    @GetMapping("")
    public ResponseEntity<List<User>> getUsers() {
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }
    
    @PostMapping("/signin")
    public ResponseEntity<?> signIn(@RequestBody SignInRequest signInRequest) {
    	try {
    		return new ResponseEntity<>(userService.signIn(signInRequest), HttpStatus.OK);
    	} catch (Exception e) {
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    	}
    }
    
    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestBody SignUpRequest signUpRequest) {
    	try {
    		return new ResponseEntity<>(userService.signUp(signUpRequest), HttpStatus.OK);
    	} catch (Exception e) {
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    	}
    }
    
    @GetMapping("/{username}")
    public ResponseEntity<?> getByUsername(@PathVariable String username) {
    	try {
    		return new ResponseEntity<>(userService.getByUsername(username), HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
        
    }
    
    @DeleteMapping("/delete/{username}")
    public ResponseEntity<?> deleteByUsername(@PathVariable String username) {
    	try {
            userService.deleteByUsername(username);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    
    @PutMapping("/update")
    public ResponseEntity<?> updateUser(@RequestBody UpdateRequest newUser) {
    	try {
            userService.updateUser(newUser);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}