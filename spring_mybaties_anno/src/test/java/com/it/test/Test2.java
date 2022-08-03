package com.it.test;


import com.it.domain.Order;
import com.it.domain.User;
import com.it.mapper.OrderMapper;
import com.it.mapper.UserMapper;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test2 {
    OrderMapper Mapper=null;
    @Before
    public  void before() throws IOException {
        InputStream inputStream=Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session=sqlSessionFactory.openSession(true);
        Mapper =session.getMapper(OrderMapper.class);
    }
    @Test
    public  void query() throws IOException {
        List<Order>orderList=Mapper.findAll();
        for(Order k:orderList) {
            System.out.println(k);
        }

    }
}
