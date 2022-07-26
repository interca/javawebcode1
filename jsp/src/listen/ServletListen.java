package listen;

import jakarta.servlet.ServletContextEvent;

import javax.servlet.ServletContextListener;

//监听器的实现
public class ServletListen implements ServletContextListener {


    @Override
    public void contextInitialized(javax.servlet.ServletContextEvent servletContextEvent) {
        System.out.println("初始化");
    }

    @Override
    public void contextDestroyed(javax.servlet.ServletContextEvent servletContextEvent) {
        System.out.println("结束");
    }
}
