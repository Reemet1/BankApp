package com.prometheus.bank.rest.controller;

import com.prometheus.bank.entity.User;
import com.prometheus.bank.rest.exception.UserNotFoundException;
import com.prometheus.bank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api")
public class UserRestController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers() {

        List<User> users = userService.getAllUsers();
        if(users == null) users = new ArrayList<>();

        return users;
    }

    @GetMapping("/users/{userId}")
    public User getUser(@PathVariable long userId) {

        User user = userService.getUser(userId);

        if(user == null) {
            throw new UserNotFoundException("User with id " + userId + " not found");
        }

        return user;
    }

    @PostMapping("/users")
    public void addStudent(@RequestBody User user) {

        user.setId(0);
        userService.saveUser(user);
    }

    @PutMapping("/users")
    public void updateUser(@RequestBody User user) {

        userService.updateUser(user);
    }

    @DeleteMapping("/users/{userId}")
    public void deleteUser(@PathVariable long userId) {

        userService.deleteUser(userId);
    }

}
