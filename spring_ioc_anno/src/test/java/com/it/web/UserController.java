package com.it.web;

import com.it.config.SpringCofiguration;
import com.it.service.UserService;
import com.it.service.impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.Callable;

public class UserController {
    @Test
    public  void test1(){
       ApplicationContext app=new AnnotationConfigApplicationContext(SpringCofiguration.class);
        UserService service= (UserService) app.getBean("userService");
        service.save();
    }


}
