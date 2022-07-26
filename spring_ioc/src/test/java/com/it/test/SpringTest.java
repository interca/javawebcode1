package com.it.test;

import com.it.dao.UserDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.awt.*;

public class SpringTest {
     @Test
     public  void test1(){
         //测试地址
         ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext.xml");
         UserDao userDao1= (UserDao) app.getBean("userDao");
         System.out.println(userDao1);
     }
}
