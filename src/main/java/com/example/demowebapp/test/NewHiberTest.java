package com.example.demowebapp.test;

import com.example.demowebapp.dao.impl.EmployeeDao;
import com.example.demowebapp.dao.impl.ProductDao;
import com.example.demowebapp.db.JPAService;
import com.example.demowebapp.db.config.JpaConfiguration;
import com.example.demowebapp.entity.Employee;
import com.example.demowebapp.entity.Product;

public class NewHiberTest {
    public static void main(String[] args) {
        JpaConfiguration jpaConfiguration = new JpaConfiguration();
        jpaConfiguration.setUserName("root");
        jpaConfiguration.setPassword("");
        jpaConfiguration.setUrl("com.mysql.jdbc.Driver");
        jpaConfiguration.setDriver("jdbc:mysql://localhost:3308/j1023_db");
        jpaConfiguration.setPersistentUnit(Product.class.getSimpleName());

        JPAService.initialize(jpaConfiguration);

        ProductDao productDao = new ProductDao();
        Product product1 = new Product();
        product1.setName("Apple");
        product1.setWeight(0.24);

        Product product2 = new Product();
        product2.setName("Carrot");
        product2.setWeight(0.22);

        productDao.create(product2);
        productDao.create(product1);

        productDao.findAll().forEach(product -> {
            System.out.println(product);
        });
    }
}
