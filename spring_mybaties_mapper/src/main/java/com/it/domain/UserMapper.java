package com.it.domain;

import java.util.List;

public interface UserMapper {
    public List<User> findByCondition(User user);
    public List<User>findByIds(List<Integer>list);

    public  List<User>findAll();
}
