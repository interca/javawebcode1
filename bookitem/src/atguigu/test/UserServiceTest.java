package atguigu.test;

import atguigu.pojo.User;
import atguigu.service.UserService;
import atguigu.service.impl.UserServiceImpl;
import org.junit.Test;

public class UserServiceTest {
    UserService userService=new UserServiceImpl();
    @Test
    public void RegistUser(){
        userService.RegistUser(new User(0,"黄裕甲11","1111","163456"));
    }
    //登录
    @Test
    public void login(){
        System.out.println(userService.login(new User(0,"黄裕","1111","163434")));
    }
    //检测用户名是否可用
    @Test
    public void existsUsername(){
        if(userService.existsUsername("hyj")){
            System.out.println("用户名存在");
        }else {
            System.out.println("用户不存在");
        }
    }

}
