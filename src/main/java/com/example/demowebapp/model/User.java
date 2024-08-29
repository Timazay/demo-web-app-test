package com.example.demowebapp.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "USERS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;
    @Column(name = "name", length = 128)
    private String name;
    @Column(name = "email", length = 128, nullable = false)
    private String email;
    @Column(name = "password", length = 128, nullable = false)
    private String password;
    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private Role role;
    @Column(name = "is_active", length = 1)
    private boolean isActive;
    @Column(name = "created_ts")
    private Timestamp createdTs;
    @Column(name = "update_ts")
    private Timestamp updatedTs;

}
