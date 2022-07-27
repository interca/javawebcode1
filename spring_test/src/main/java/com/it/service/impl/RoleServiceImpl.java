package com.it.service.impl;

import com.it.dao.RoleDao;
import com.it.domain.Role;
import com.it.service.RoleService;

import java.util.List;

public class RoleServiceImpl implements RoleService {

    private RoleDao roleDao;
    @Override
    public List<Role> list() {
        List<Role>roleList=roleDao.findAll();
        return roleList;
    }

    @Override
    public void save(Role role) {
       roleDao.save(role);
       }


    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }
}
