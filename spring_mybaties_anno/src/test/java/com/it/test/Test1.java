package com.it.test;


import com.it.domain.User;
import com.it.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test1 {
    UserMapper Mapper=null;
    @Before
    public  void before() throws IOException {
        InputStream inputStream=Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session=sqlSessionFactory.openSession(true);
        Mapper =session.getMapper(UserMapper.class);
    }
    @Test
    public  void query() throws IOException {
        List<User>orderList=Mapper.findAll();
        for(User k:orderList) {
            System.out.println(k);
        }

    }

    @Test
    public  void insert(){
        User user=new User();
        user.setUsername("lihua");
        user.setPassword("1234");
        Mapper.save(user);
    }

    @Test
    public  void query2(){

    }

}
