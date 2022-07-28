package com.it.anno;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//交给spring容器
@Aspect//当前类是切面
@Component("myAspect")
public class MyAspect {
    //配置前置增强
    @Before(value = "execution(public void com.it.aop.Target.save())")
    public void before(){
        System.out.println("前置增强");
    }
    public  void after(){
        System.out.println("后置增强");
    }
}
