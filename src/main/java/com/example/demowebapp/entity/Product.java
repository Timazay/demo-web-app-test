package com.example.demowebapp.entity;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@ToString
@NoArgsConstructor

@Entity(name = "Product")
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productCode", nullable=false)
    private String id;
    @Column(name = "productName", nullable=false)
    private String productName;
    @ManyToOne
    @JoinColumn(name = "productLine")
    private ProductLine productLine;
    @Column(name = "productScale", nullable=false)
    private String productScale;
    @Column(name = "productVendor", nullable=false)
    private String productVendor;
    @Column(name = "productDescription", nullable=false)
    private String productDescription;
    @Column(name = "quantityInStock", nullable=false)
    private int quantityInStock;
    @Column(name = "buyPrice", nullable=false)
    private double buyPrice;
    @Column(name = "MSRP", nullable=false)
    private double MSRP;
    @Column(name = "name")
    private String name;
    @Column(name = "weight",  columnDefinition = "double DEFAULT '-1.0'")
    private Double weight;




}
