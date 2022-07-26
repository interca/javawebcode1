package com.it.test;

import com.it.domain.Account;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.beans.PropertyVetoException;
import java.util.List;

public class jdbcTemplateTest {
    //测试jdbc模版
    @Test
    public void test1() throws PropertyVetoException {
        System.out.println(1);
        //创建数据源对象
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/test?characterEncoding=UTF-8&useConfigs=maxPerformance");
        dataSource.setUser("root");
        dataSource.setPassword("13538026482");
        JdbcTemplate jdbcTemplate=new JdbcTemplate();
        //设置数据源
        jdbcTemplate.setDataSource(dataSource);
        //执行操作
        jdbcTemplate.update("insert into  account values(?,?)","黄裕甲",5000);


    }

    public static void main(String[] args) throws PropertyVetoException {
        System.out.println(1);
        //创建数据源对象
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/test?characterEncoding=UTF-8&useConfigs=maxPerformance");
        dataSource.setUser("root");
        dataSource.setPassword("13538026482");
        JdbcTemplate jdbcTemplate=new JdbcTemplate();
        //设置数据源
        jdbcTemplate.setDataSource(dataSource);
        //执行操作
        //jdbcTemplate.update("insert into  account values(?,?)","李裕甲",15000);
        //查询
        List<Account> query = jdbcTemplate.query("select *from account", new BeanPropertyRowMapper<Account>(Account.class));
        System.out.println(query);
        //查询一个
        Account account = jdbcTemplate.queryForObject
                ("select *from account where name=?",
                        new BeanPropertyRowMapper<Account>(Account.class), "黄裕甲");
        System.out.println(account);
    }
}
