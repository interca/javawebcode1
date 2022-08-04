package com.it.domain.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.it.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao extends BaseMapper<User> {


}
