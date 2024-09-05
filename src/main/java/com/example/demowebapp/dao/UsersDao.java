package com.example.demowebapp.dao;

import com.example.demowebapp.db.AbstractJpaDAO;
import com.example.demowebapp.model.User;

import java.sql.Timestamp;
import java.util.Objects;

public class UsersDao extends AbstractJpaDAO<Integer, User> {

    public User findUserByEmail(String email){
        return findFirst(String.format("email = '%s'", email));
    }

    public boolean activate(final String email){
      User user = findUserByEmail(email);
      user.setActive(true);
      user.setUpdatedTs(new Timestamp(System.currentTimeMillis()));

     return !Objects.isNull(update(user));
    }
}
