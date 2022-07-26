package com.it.dao.impl;

import com.it.dao.UserDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

// <bean id="userDao" class="com.it.dao.impl.UserDaoImpl"></bean>
//@Component("userDao")
@Repository("userDao")
public class UserDaoImpl implements UserDao {

    @Override
    public void save() {
        System.out.println("saveunning");
    }
}
