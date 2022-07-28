package com.it.test;

import com.it.anno.Target;
import com.it.anno.TargetInterface;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
//指明配置文件
@ContextConfiguration("classpath:applicationContext2.xml")
public class AnnoTest {

    
    @Autowired
    private TargetInterface targetInterface;
    @Test
    public  void test1(){
        targetInterface.save();
    }
}


