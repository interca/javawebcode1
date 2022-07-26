package atguigu.service;

import atguigu.pojo.User;

//业务层
public interface UserService {
    //注册
    public int RegistUser(User user);
    //登录
    public User login(User user);
    //检测用户名是否可用
    public boolean existsUsername(String username);

}
