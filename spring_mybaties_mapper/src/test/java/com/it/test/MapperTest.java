package com.it.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.it.domain.User;
import com.it.domain.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MapperTest {
    @Test
    public  void test1() throws IOException {
        InputStream inputStream= Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session=sqlSessionFactory.openSession();

        User user=new User();
        user.setId(8);
        user.setPassword("abc");
        user.setUsername("tom");
        UserMapper userMapper=session.getMapper(UserMapper.class);
        List<User> list=userMapper.findByCondition(user);
        System.out.println(list);

    }
    @Test
    public  void test2() throws IOException {
        InputStream inputStream= Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session=sqlSessionFactory.openSession();
        List<Integer>list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        UserMapper userMapper=session.getMapper(UserMapper.class);
        List<User> byIds = userMapper.findByIds(list);
        System.out.println(byIds);
    }
    @Test
    public  void test3() throws IOException {
        InputStream inputStream= Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session=sqlSessionFactory.openSession();
        UserMapper userMapper=session.getMapper(UserMapper.class);
        PageHelper.startPage(2,3);
        List<User>list=userMapper.findAll();
        for(User user:list){
            System.out.println(user);
        }
        PageInfo<User>pageInfo=new PageInfo<>(list);
        System.out.println("当前页"+pageInfo.getPageNum());
        System.out.println("每页显示数量"+pageInfo.getPageSize());
        System.out.println("总条数"+pageInfo.getTotal());
        System.out.println("总页数"+pageInfo.getPages());
        System.out.println("上一页"+pageInfo.getPrePage());
        System.out.println("下一页"+pageInfo.getNextPage());
        System.out.println("是否第一页"+pageInfo.isIsFirstPage());
        System.out.println("是否最后一页"+pageInfo.isIsLastPage());
        session.close();

    }
}

