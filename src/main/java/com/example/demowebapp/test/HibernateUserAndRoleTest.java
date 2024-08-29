package com.example.demowebapp.test;

import com.example.demowebapp.model.Role;
import com.example.demowebapp.model.User;
import com.example.demowebapp.utils.HibernateAnnotationUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

public class HibernateUserAndRoleTest {
    public static void main(String[] args) {
        Session session = null;

        try (SessionFactory sessionFactory = HibernateAnnotationUtil.getSessionFactory()) {
            session = sessionFactory.getCurrentSession();
            Transaction txn = session.beginTransaction();

            Role role = session.get(Role.class, 1);
            User user = new User();
            user.setName("Tim");
            user.setEmail("ooo");
            user.setActive(true);
            user.setPassword("123");
            user.setRole(role);

            session.save(user);
            System.out.println(user.toString());
            txn.commit();
        }


    }
}
