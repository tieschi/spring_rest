package com.tiesch.spring.rest.dao;

import com.tiesch.spring.rest.model.User;

import java.util.List;

public interface UserDao {

    List<User> getAllUsers();
    void addUser(User user);
    User getUser(int id);
    void deleteUser(User user);

}
