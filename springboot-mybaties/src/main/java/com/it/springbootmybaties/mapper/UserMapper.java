package com.it.springbootmybaties.mapper;

import com.it.springbootmybaties.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from t_user")
    public List<User> findAll();
}
