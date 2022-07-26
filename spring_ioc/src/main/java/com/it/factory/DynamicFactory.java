package com.it.factory;

import com.it.dao.UserDao;
import com.it.dao.impl.UserDaoImpl;

public class DynamicFactory {
    public UserDao getUserDao(){
        System.out.println("工厂");
        return new UserDaoImpl();
    }
}
