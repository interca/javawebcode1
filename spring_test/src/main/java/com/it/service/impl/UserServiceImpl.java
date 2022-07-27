package com.it.service.impl;

import com.it.dao.RoleDao;
import com.it.dao.UserDao;
import com.it.domain.Role;
import com.it.domain.User;
import com.it.service.UserService;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao;
    private RoleDao roleDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> list() {

        List<User>userList=userDao.findAll();
        for (User user : userList) {
            //获得user的id
            Long id=user.getId();
            //将Id作为参数，查询id对应的role的集合
            List<Role>roleList=roleDao.findRoleByUserId(id);
            user.setRoleLists(roleList);
           // System.out.println(roleList);
        }
        return userList;
    }

    @Override
    public void save(User user, long[] roleIds) {
        Long id=userDao.save(user);
        userDao.saveUserRoleRel(id,roleIds);

    }

    @Override
    public void del(Long userId) {
        //删除sys_user_role
        userDao.delUserRoleRel(userId);
        //删除sysy_user
        userDao.del(userId);
    }

    @Override
    public User login(String username, String password) {
        User user=null;
        try {
           user=userDao.findByUsernameAndPassword(username,password);
           return user;
        } catch (EmptyResultDataAccessException e) {
           return null;
        }
    }

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }
}

