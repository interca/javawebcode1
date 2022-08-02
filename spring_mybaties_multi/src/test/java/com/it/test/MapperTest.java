package com.it.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.it.domain.Order;
import com.it.domain.User;
import com.it.mapper.OrderMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MapperTest {
   @Test
    public  void test1() throws IOException {
       InputStream inputStream=Resources.getResourceAsStream("sqlMapConfig.xml");
       SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
       SqlSession session=sqlSessionFactory.openSession();


       OrderMapper orderMapper=session.getMapper(OrderMapper.class);
       List<Order>orderList=orderMapper.findAll();
       for(Order k:orderList){
          System.out.println(k);
       }
   }
}

