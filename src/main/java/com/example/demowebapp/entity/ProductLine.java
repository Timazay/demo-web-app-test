package com.example.demowebapp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@ToString(exclude = "products")
@NoArgsConstructor
@Entity
@Table(name = "productlines")
public class ProductLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productLine", nullable = false)
    private String productLine;
    @Column(name = "textDescription")
    private String textDescription;
    @Column(name = "htmlDescription")
    private String htmlDescription;
    @Column(name = "image", columnDefinition = "MEDIUMBLOB")
    private byte[] image;
    @OneToMany(mappedBy = "productLine")
    private Set<Product> products;

}
