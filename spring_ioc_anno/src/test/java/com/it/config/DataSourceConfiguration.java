package com.it.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@PropertySource("classpath:jdbc.properties")//加载配置文件
public class DataSourceConfiguration {
    //通过注解来注入数据库内容
    @Value("${driverClassName}")
    private String driver;
    @Value("${url}")
    private String url;
    @Value("${username1}")
    private String username;
    @Value("${password}")
    private String password;


    @Bean("dataSource")//spring将当前方法的返回值以指定名称加入到容器当中
    public DataSource gerDataSource(){

        System.out.println(username);
        DruidDataSource druidDataSource=new DruidDataSource();
        druidDataSource.setDriverClassName(driver);
        druidDataSource.setUrl(url);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        return druidDataSource;
    }
}
