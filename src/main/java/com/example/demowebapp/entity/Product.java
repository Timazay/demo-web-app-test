package com.example.demowebapp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

@Entity(name = "Product")
@Table(name = "products_v2")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable=false)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "weight")
    private double weight;
}
