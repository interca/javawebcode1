package com.it;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.it.domain.User;
import com.it.domain.dao.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

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

    @Test
    public  void test4(){
        IPage page=new Page(1,2);
        userDao.selectPage(page,null);
        System.out.println("当前页码值"+page.getCurrent());
        System.out.println("每页显示数"+page.getSize());
        System.out.println("一共多少页"+page.getPages());
        System.out.println("一共多少数据"+page.getTotal());
        System.out.println("数据"+page.getRecords());
    }

    @Test
    void quarry(){
        //按条件查询
       // QueryWrapper qw=new QueryWrapper<>();
        //查询编号小于5的人
       // qw.lt("id",5);

        //Lambda格式的条件查询
       // QueryWrapper<User> qw=new QueryWrapper<>();
        //qw.lambda().lt(User::getId,5);

        //第三种查询方式
        LambdaQueryWrapper<User>qw=new LambdaQueryWrapper<>();
        //大于二小于5
       // qw.lt(User::getId,5);
        //qw.gt(User::getId,2);

        //小于2或者大于5,ge,le是等于
        //qw.lt(User::getId,2).or().gt(User::getId,5);

        //等于查询
        qw.eq(User::getUsername,"小马");
        List<User>list=userDao.selectList(qw);
        System.out.println(list);
    }

    //查询投影
    @Test
    void quary2(){
        LambdaQueryWrapper<User>qw=new LambdaQueryWrapper<>();
        qw.select(User::getUsername,User::getId);
        List<User>list=userDao.selectList(qw);
        System.out.println(list);
    }

    @Test
    void quary3(){
       QueryWrapper<User>qw=new QueryWrapper<>();
        qw.select("count(*) as count,password ");
        //分组
        qw.groupBy("password");
        List<Map<String, Object>> list=userDao.selectMaps(qw);
        System.out.println(list);
    }

    @Test
    void quary4(){
        //条件查询多条件
        LambdaQueryWrapper<User>qw=new LambdaQueryWrapper<>();
        qw.eq(User::getUsername,"小马")
                .eq(User::getPassword,"22222");
        List<User> userList = userDao.selectList(qw);
        System.out.println(userList);
    }

    @Test
    void update(){
        User user=new User();
        user.setUsername("小黄");
        user.setId(4);
        userDao.updateById(user);
    }
}

