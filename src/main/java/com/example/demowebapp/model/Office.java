package com.example.demowebapp.model;

import com.example.demowebapp.entity.Employee;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = "employees")
@Entity
@Table(name = "offices")
public class Office {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "officeCode", nullable = false)
    private String officeCode;
    @Column(name = "city", nullable = false)
    private String city;
    @Column(name = "phone", nullable = false)
    private String phone;
    @Column(name = "addressLine1", nullable = false)
    private String addressLine1;
    @Column(name = "addressLine2", columnDefinition = "NULL")
    private String addressLine2;
    @Column(name = "state", columnDefinition = "NULL")
    private String state;
    @Column(name = "country",  nullable = false)
    private String country;
    @Column(name = "postalCode", nullable = false)
    private String postalCode;
    @Column(name = "territory", nullable = false)
    private String territory;
    @OneToMany(mappedBy = "office")
    private Set<Employee> employees;

}
