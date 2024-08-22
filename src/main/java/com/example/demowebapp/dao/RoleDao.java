package com.example.demowebapp.dao;

import com.example.demowebapp.model.Office;
import com.example.demowebapp.model.Role;
import com.example.demowebapp.model.User;

import java.sql.SQLException;

public interface RoleDao {
     Role findRoleById(int id);
     Role findByUser(User user);
}
