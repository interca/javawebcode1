package com.it.service;

import com.it.domain.Role;

import java.util.List;

public interface RoleService  {

    public List<Role> list();

    void save(Role role);
}
