package atguigu.service.impl;

import atguigu.dao.UserDao;
import atguigu.dao.impl.UserDaoImpl;
import atguigu.pojo.User;
import atguigu.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao=new UserDaoImpl();//dao操作数据库
    @Override
    public int RegistUser(User user) {
       return userDao.SaveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public boolean existsUsername(String username) {
         User user=userDao.queryByUsername(username);
         if(user!=null) return true;
         return false;
    }
}
