package com.it.test;

import com.it.config.SpringCofiguration;
import com.it.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:applicationContext.xml")
@ContextConfiguration(classes = {SpringCofiguration.class})
public class SpringJunitTest {

    @Autowired
    private UserService userService;

    @Test
    public  void test(){
        userService.save();
    }
}
