package com.example.demowebapp.dao;


import com.example.demowebapp.utils.HibernateAnnotationUtil;
import org.hibernate.HibernateError;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;


public abstract class AbstractDao<PK extends Serializable, T> {

    private final Class<T> persistentClass;

    @SuppressWarnings("unchecked")
    public AbstractDao(){
        this.persistentClass =(Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    protected Session getSession(){
        return HibernateAnnotationUtil.getSessionFactory().getCurrentSession();
    }


    @SuppressWarnings("unchecked")
    public T getByKey(PK key) {
        Transaction txn = null;
        try ( Session session = getSession()){
           txn = session.beginTransaction();
            return getSession().get(persistentClass, key);
        } catch (Exception e) {
            if (txn != null) {
                e.printStackTrace();
                txn.rollback();
            }
            throw  new HibernateException("Getting entity error", e);
        }

    }


    public void persist(T entity) {
        Transaction txn = null;
        try (Session session = getSession()){
            txn = session.beginTransaction();
            session.persist(entity);
        } catch (Exception e) {
            if (txn != null) {
                e.printStackTrace();
                txn.rollback();
            }
            throw  new HibernateException("Getting entity error", e);
        }


    }


    public void update(T entity) {
        Transaction txn = null;
        try ( Session session = getSession()){
            txn = session.beginTransaction();
            session.merge(entity);
        } catch (Exception e) {
            if (txn != null) {
                e.printStackTrace();
                txn.rollback();
            }
            throw  new HibernateException("Getting entity error", e);
        }

    }


    public void delete(T entity) {
        Transaction txn = null;
        try (Session session = getSession()){
            txn = session.beginTransaction();
            session.remove(entity);
            txn.commit();
        } catch (Exception e) {
            if (txn != null) {
                e.printStackTrace();
                txn.rollback();
            }
            throw  new HibernateException("Getting entity error", e);
        }
    }




}

