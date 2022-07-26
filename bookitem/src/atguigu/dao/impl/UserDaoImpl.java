package atguigu.dao.impl;

import atguigu.dao.UserDao;
import atguigu.pojo.User;

public class UserDaoImpl extends BaseDao implements UserDao {

    @Override
    public User queryByUsername(String username) {
        String sql="select id,username,password,email from user_book where username=?";
        return queryForOne(User.class,sql,username);
    }

    //保存数据并且返回影响的行数
    @Override
    public int SaveUser(User user) {
        String sql="insert into user_book(username,password,email)values(?,?,?)";
        return update(sql,user.getUsername(),user.getPassword(),user.getEmail());
    }

    @Override
    public User queryByUsernameAndPassword(String username, String password) {
        String sql="select id,username,password,email from user_book where username=? and password=?";
        return queryForOne(User.class,sql,username,password);
    }
}
