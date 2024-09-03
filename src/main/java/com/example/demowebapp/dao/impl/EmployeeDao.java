package com.example.demowebapp.dao.impl;

import com.example.demowebapp.dao.AbstractDao;
import com.example.demowebapp.db.AbstractJpaDAO;
import com.example.demowebapp.entity.Employee;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class EmployeeDao extends AbstractJpaDAO<Integer, Employee> {


}
