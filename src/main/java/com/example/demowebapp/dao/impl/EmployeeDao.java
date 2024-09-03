package com.example.demowebapp.dao.impl;

import com.example.demowebapp.dao.AbstractDao;
import com.example.demowebapp.entity.Employee;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class EmployeeDao extends AbstractDao<Integer, Employee> {
    @Override
    public void update(Employee entity) {
        super.update(entity);
    }

    @Override
    public void delete(Employee entity) {
        super.delete(entity);
    }

    @Override
    public void persist(Employee entity) {
        super.persist(entity);
    }
}
