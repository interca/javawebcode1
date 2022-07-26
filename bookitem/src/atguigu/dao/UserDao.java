package atguigu.dao;

import atguigu.pojo.User;

public interface UserDao {
    //根据用户名查询用户信息
    public User queryByUsername(String username);
    //保存用户信息
    public int SaveUser(User user);
    //查询用户名和密码，登录时候用,返回Null,用户名或者密码错误
    public User queryByUsernameAndPassword(String username,String password);

}
