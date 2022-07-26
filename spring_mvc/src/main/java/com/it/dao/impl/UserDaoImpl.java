package com.it.dao.impl;

import com.it.dao.UserDao;

public class UserDaoImpl implements UserDao {
    @Override
    public void save() {
        System.out.println("save");
    }
}
