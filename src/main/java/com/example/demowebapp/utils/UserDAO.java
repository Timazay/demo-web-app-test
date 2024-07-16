package com.example.demowebapp.utils;

import com.example.demowebapp.model.User;

public interface UserDAO {
    User findUserByEmail(String email);
    boolean createUser(User user);


}
