package com.it.test;

import com.it.domain.User;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class Mybaties {
    InputStream resourceAsStream=null;
    SqlSessionFactory sqlSessionFactory=null;
    SqlSession sqlSession =null;
    @Test
    public  void method() throws IOException {
      //获取核心配置文件
         resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获取session工厂对象
         sqlSessionFactory= new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得session会话对象
         sqlSession = sqlSessionFactory.openSession();

    }
    @Test
    public  void upadate() throws IOException {
        method();
        User user=new User();
        user.setId(4);
        user.setUsername("黄裕甲");
        user.setPassword("10085");
        sqlSession.update("userMapper.update",user);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public  void insert() throws IOException {
        User user=new User();
        user.setUsername("tom");
        user.setPassword("abc");
        method();
        sqlSession.insert("userMapper.save",user);
        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void quary() throws IOException {
        method();
        //查询
        List<User> userList=sqlSession.selectList("userMapper.findAll");
        //打印数据
        for(User K:userList){
            System.out.println(K);
        }
        sqlSession.close();
    }
    @Test
    public  void delect() throws IOException {
        method();
        sqlSession.delete("userMapper.delete",3);
        sqlSession.commit();
        sqlSession.close();
    }

}



