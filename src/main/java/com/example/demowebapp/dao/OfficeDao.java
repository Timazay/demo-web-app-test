package com.example.demowebapp.dao;

import com.example.demowebapp.model.Office;

import java.util.Set;

public interface OfficeDao {
    Office findOfficeByPhone(String phone);
    boolean createOffice(Office office);
    void update(Office office);
    boolean deleteOffice(int id);
    Set<Office> findAll();

}
