package com.example.demowebapp.dao;

import com.example.demowebapp.db.AbstractJpaDAO;
import com.example.demowebapp.model.Office;

public class OfficesDao extends AbstractJpaDAO<String, Office> {
    public Office findOfficeByPhone(String phone){
        return findFirst(String.format("phone = '%s'", phone));
    }
}
