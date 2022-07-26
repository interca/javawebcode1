package com.it.service;

import com.it.domain.Role;
import com.it.domain.User;

import java.util.List;

public interface UserService {

    List<User> list();

    void save(User user, long[] roleIds);

    void del(Long userId);

    User login(String username, String password);
}
