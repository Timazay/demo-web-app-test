package com.example.demowebapp.model;

import com.example.demowebapp.entity.Employee;
import lombok.*;

import jakarta.persistence.*;

import java.util.Set;


@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "description")
    private String description;
    @OneToMany(mappedBy = "role")
    private Set<User> users;

    public Role(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
}
