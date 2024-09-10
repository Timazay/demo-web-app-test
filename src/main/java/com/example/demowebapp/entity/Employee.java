package com.example.demowebapp.entity;

import com.example.demowebapp.model.Office;
import lombok.*;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@ToString(exclude = "heads")
@NoArgsConstructor
@Entity
@Table(name = "Employees", uniqueConstraints = {@UniqueConstraint(columnNames = {"ID"})})
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employeeNumber", nullable = false)
    private int employeeNumber;
    @Column(name = "lastName", length = 50, nullable = false)
    private String lastName;
    @Column(name = "firstName", length = 50, nullable = false)
    private String firstName;
    @Column(name = "extension", length = 10, nullable = false)
    private String extension;
    @Column(name = "email", length = 100, nullable = false)
    private String email;
    @ManyToOne
    @JoinColumn(name = "officeCode")
    private Office office;
    @ManyToOne
    @JoinColumn(name = "reportsTo")
    private Employee reportsTo;
    @Column(name = "jobTitle", length = 50, nullable = false)
    private String jobTitle;
    @OneToMany(mappedBy = "reportsTo")
    private Set<Employee> heads;


}
