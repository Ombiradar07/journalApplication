package com.osmbiradar.journals.controller;

import com.osmbiradar.journals.entity.Users;
import com.osmbiradar.journals.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-entries")
public class UserController {
    
    private final UserService userService;
    
    public UserController(UserService userService) {
        this.userService = userService;
    }
    
    @PostMapping("/create")
    public ResponseEntity<Users> createUser(@RequestBody Users user) {
        Users savedUser = userService.createUser(userService.createUser(user));
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("/get")
    public ResponseEntity<Users> getUser(@PathVariable ObjectId id) {
        Users foundUser = userService.getUserById(id);
        return new ResponseEntity<>(foundUser, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Users> updateUser(@RequestBody Users user) {
        Users updatedUser = userService.updateUser(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable ObjectId id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/allUsers")
    public ResponseEntity<Iterable<Users>> getAllUsers() {
        List<Users> allUsers = userService.getAllUsers();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }
    
    
    
}
