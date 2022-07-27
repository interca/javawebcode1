package com.it.dao;

import com.it.domain.Role;
import com.it.domain.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();

    Long save(User user);

    void saveUserRoleRel(Long id, long[] roleIds);

    void delUserRoleRel(Long userId);

    void del(Long userId);

    User findByUsernameAndPassword(String username, String password);
}
