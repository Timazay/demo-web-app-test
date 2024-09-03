package com.example.demowebapp.dao.impl;

import com.example.demowebapp.dao.AbstractDao;
import com.example.demowebapp.model.Role;

public class RoleDao extends AbstractDao<Integer, Role> {
    @Override
    public void delete(Role entity) {
        super.delete(entity);
    }

    @Override
    public void persist(Role entity) {
        super.persist(entity);
    }

    @Override
    public void update(Role entity) {
        super.update(entity);
    }
}
