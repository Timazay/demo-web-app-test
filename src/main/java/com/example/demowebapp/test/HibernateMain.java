package com.example.demowebapp.test;

import java.sql.SQLException;
import java.util.Date;

import com.example.demowebapp.dao.impl.EmployeeDao;
import com.example.demowebapp.entity.Employee;
import com.example.demowebapp.utils.HibernateAnnotationUtil;
import com.example.demowebapp.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class HibernateMain {
    static EmployeeDao dao = new EmployeeDao();

    public static void main(String[] args) {
        Employee e = dao.getByKey(25);
        System.out.println(e);

        /*Employee emp = new Employee();
        emp.setName("Pankaj");
        emp.setRole("CEO");
        emp.setInsertTime(new Date());

        //Get Session
        *//*Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        //start transaction
        session.beginTransaction();
        //Save the Model object
        session.save(emp);
        //Commit transaction
        session.getTransaction().commit();
        System.out.println("Employee ID=" + emp.getId());*//*
        Transaction txn = null;
        try (Session ses = HibernateAnnotationUtil.getSessionFactory().getCurrentSession();) {
            txn = ses.beginTransaction();
            Employee employee = ses.get(Employee.class, 25);
            txn.commit();
            System.out.println(employee);

        } catch (Exception e) {
            e.printStackTrace();
            if (txn != null) {
                txn.rollback();
            }
        } finally {
            HibernateAnnotationUtil.close();

        }
        */
    }
}
