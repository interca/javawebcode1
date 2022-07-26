package atguigu.test;

import atguigu.dao.UserDao;
import atguigu.dao.impl.UserDaoImpl;
import atguigu.pojo.User;
import org.junit.Test;

public class UserDaoTest {
    UserDao userDao=new UserDaoImpl();
    @Test
    public void queryByUsername(){
        User user=userDao.queryByUsername("hyj");
        if(user==null) System.out.println("用户名已经存在");
        else System.out.println("用户名重复");
    }

    @Test
    public void SaveUser(){
       int a=userDao.SaveUser(new User(1,"黄里力量","12345","1234@qq.com"));
       if(a==-1) System.out.println("输入有误");
       else {
           System.out.println("注册成功");
       }
    }

    @Test
    public void queryByUsernameAndPassword(){
       User user=userDao.queryByUsernameAndPassword("hyj","hyj123");
       if(user==null) System.out.println("登录失败");
       else System.out.println("登录成功");
    }
}
