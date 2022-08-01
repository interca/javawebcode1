package com.it.springbootmybaties.mapper;


import com.it.springbootmybaties.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//xml配置
@Mapper
public interface UserXmlMapper {

    public List<User>findAll();

}
