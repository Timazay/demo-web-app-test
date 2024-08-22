package com.example.demowebapp.model;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class User {
    private int id;
    private String name;
    private String email;
    private String password;
    private Role role;
    private boolean isActive;
    private Timestamp createdTs;
    private Timestamp updatedTs;


}
