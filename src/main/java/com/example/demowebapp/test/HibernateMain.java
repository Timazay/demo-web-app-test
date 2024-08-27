package com.example.demowebapp.test;

import java.util.Date;

import com.example.demowebapp.entity.Employee;
import com.example.demowebapp.utils.HibernateUtil;
import org.hibernate.Session;

public class HibernateMain {

    public static void main(String[] args) {
        Employee emp = new Employee();
        emp.setName("Pankaj");
        emp.setRole("CEO");
        emp.setInsertTime(new Date());

        //Get Session
        /*Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        //start transaction
        session.beginTransaction();
        //Save the Model object
        session.save(emp);
        //Commit transaction
        session.getTransaction().commit();
        System.out.println("Employee ID=" + emp.getId());*/

        Session ses = HibernateUtil.getSessionFactory().getCurrentSession();
        ses.beginTransaction();
        Employee employee = (Employee) ses.get(Employee.class, 25);
        ses.delete(employee);
        ses.getTransaction().commit();


        //terminate session factory, otherwise program won't end
        HibernateUtil.getSessionFactory().close();
    }

}
