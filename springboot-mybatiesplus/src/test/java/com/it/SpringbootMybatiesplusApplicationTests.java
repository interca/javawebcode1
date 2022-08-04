package com.it;

import com.it.domain.User;
import com.it.domain.dao.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringbootMybatiesplusApplicationTests {

    @Autowired
   private UserDao userDao;
    @Test
    void contextLoads() {
        List<User> userList = userDao.selectList(null);
        System.out.println(userList);
    }

    @Test
    void  test2(){
        User user=new User();
        user.setUsername("小马");
        user.setPassword("22222");
        userDao.insert(user);
    }

    @Test
    public  void  delete(){
        userDao.deleteById(1);
    }

    @Test
    public  void test3(){
        User user=new User();
        user.setId(1);
        user.setUsername("小马1");
        user.setPassword("123445");
        userDao.updateById(user);
    }
}
