package com.tiesch.spring.rest.controller;

import com.tiesch.spring.rest.exception.IncorrectData;
import com.tiesch.spring.rest.exception.NoUserException;
import com.tiesch.spring.rest.model.User;
import com.tiesch.spring.rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRestController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public List<User> showAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user) {

        userService.addUser(user);
        return user;

    }

    @PutMapping("/users")
    public User updateUser(@RequestBody User user) {

        userService.addUser(user);
        return user;

    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return "User with id = " + id + "was deleted";
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable int id) {
        User user = userService.getUser(id);
        if (user == null) {
            throw new NoUserException("no user with id = " + id);
        }
        return user;
    }

    @ExceptionHandler
    public ResponseEntity<IncorrectData> handleException(NoUserException exception) {
        IncorrectData data = new IncorrectData();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<IncorrectData> handleException(Exception exception) {
        IncorrectData data = new IncorrectData();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }

}
