package com.it.factory;

import com.it.dao.UserDao;
import com.it.dao.impl.UserDaoImpl;

public class staticFactory {
    public static UserDao getUserDao(){
        System.out.println("工厂");
        return new UserDaoImpl();
    }
}
