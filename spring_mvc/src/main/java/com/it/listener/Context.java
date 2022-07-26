package com.it.listener;

import com.it.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class Context implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext.xml");
        //将spring应用的上下文对象存储到最大域中
        ServletContext servletContext = servletContextEvent.getServletContext();
        servletContext.setAttribute("app",app);

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
