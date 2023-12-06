package com.tiesch.spring.rest.service;

import com.tiesch.spring.rest.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();
    void addUser(User user);
    User getUser(int id);
    void deleteUser(int id);

}
