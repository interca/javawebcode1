package com.it.service.impl;

import com.it.dao.UserDao;
import com.it.dao.impl.UserDaoImpl;
import com.it.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//<bean id="userService" class="com.it.service.impl.UserServiceImpl">
//@Component("userService")
@Service("userService")
public class UserServiceImpl implements UserService {

    @Value("itcast")
    private String driver;
   // <property name="userDao" ref="userDao"></property>
    @Autowired
    @Qualifier("userDao")
    public UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    public  void save(){
        System.out.println(driver);
        userDao.save();
    }

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserServiceImpl() {
    }
}
