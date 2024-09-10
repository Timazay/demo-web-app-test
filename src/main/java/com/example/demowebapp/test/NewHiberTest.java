package com.example.demowebapp.test;

import com.example.demowebapp.dao.*;
import com.example.demowebapp.dao.impl.EmployeeDao;
import com.example.demowebapp.dao.impl.ProductDao;
import com.example.demowebapp.db.JPAService;
import com.example.demowebapp.db.config.JpaConfiguration;
import com.example.demowebapp.entity.Employee;
import com.example.demowebapp.entity.Product;
import com.example.demowebapp.entity.ProductLine;
import com.example.demowebapp.model.Office;
import com.example.demowebapp.model.User;

public class NewHiberTest {
    public static void main(String[] args) {


        JPAService.initialize();

        ProductsDao dao = new ProductsDao();
        Product product = dao.findById("S10_1678");

        System.out.println(product.toString());

    }
}
