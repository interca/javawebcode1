package com.it.test;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.it.config.SpringCofiguration;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DataSourceTest {
   @Test
    public  void test1() throws SQLException {
       DruidDataSource druidDataSource=new DruidDataSource();
       druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
       druidDataSource.setUrl("jdbc:mysql://127.0.0.1:3306/book");
       druidDataSource.setUsername("root");
       druidDataSource.setPassword("13538026482");
      System.out.println(druidDataSource);
       DruidPooledConnection connection=druidDataSource.getConnection();
       System.out.println(connection);
       connection.close();
   }

   //spring产生数据源对象
   @Test
   public  void test2() throws SQLException {
      //ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext.xml");
      ApplicationContext app=new AnnotationConfigApplicationContext(SpringCofiguration.class);
      DataSource dataSource= (DataSource) app.getBean("dataSource");
      Connection connection=dataSource.getConnection();
      System.out.println(connection);
      connection.close();
   }

}
