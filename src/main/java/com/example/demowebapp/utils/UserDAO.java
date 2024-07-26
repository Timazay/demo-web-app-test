package com.example.demowebapp.utils;

import com.example.demowebapp.model.User;

import java.util.Set;

public interface UserDAO {
    User findUserByEmail(String email);
    boolean createUser(User user);
    boolean activate(User user);
    Set<User> findAll();


}
