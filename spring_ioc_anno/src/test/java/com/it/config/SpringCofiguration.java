package com.it.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;

//该类是spring的核心配置类
//base-package="com.it"></context:component-scan>
@Configuration
@ComponentScan("com.it")//扫描注解
//总配置引入新配置
@Import(DataSourceConfiguration.class)
public class SpringCofiguration {

}
