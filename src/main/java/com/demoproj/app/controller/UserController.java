package com.demoproj.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework. web.bind.annotation.RestController;

import com.demoproj.app.model.User;
import com.demoproj.app.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/")
public class UserController {
    
    @Autowired
    private UserService userService;

    @GetMapping("/user/{id}")
    public ResponseEntity<Optional<User>> getUser(@PathVariable String id) {
        return new ResponseEntity<Optional<User>>(userService.singleUser(id), HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<List<User>>(userService.allUsers(), HttpStatus.OK);
    }

    @GetMapping("/users/{country}")
    public ResponseEntity<List<User>> getUsersByCountry(@PathVariable String country) {
        return new ResponseEntity<List<User>>(userService.usersFromCountry(country), HttpStatus.OK);
    }

    @PostMapping("/user/add")
    public ResponseEntity<User> addUser(@RequestBody @Valid User newUser) {
        return new ResponseEntity<User>(userService.createUser(newUser), HttpStatus.CREATED);
    }

    @DeleteMapping("/user/delete/{id}")
    public ResponseEntity<Optional<User>> deleteUser(@PathVariable String id) {
        return new ResponseEntity<Optional<User>>(userService.removeUser(id), HttpStatus.NO_CONTENT);
    }

}
