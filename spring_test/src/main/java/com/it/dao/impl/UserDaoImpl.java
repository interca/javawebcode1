package com.it.dao.impl;

import com.it.dao.UserDao;
import com.it.domain.Role;
import com.it.domain.User;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private JdbcTemplate jdbcTemplate;
    @Override
    public List<User> findAll() {
        List<User> userList=jdbcTemplate.query("select *from sys_user",
                new BeanPropertyRowMapper<User>(User.class));
        return userList;
    }

    //保存用户基本信息
    @Override
    public Long save(final User user) {
        //创建PrepareStatementCreator
        PreparedStatementCreator creator=new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement statement=connection.prepareStatement("insert into sys_user values(?,?,?,?,?)",
                        PreparedStatement.RETURN_GENERATED_KEYS);
                statement.setObject(1,null);
                statement.setObject(2,user.getUsername());
                statement.setObject(3,user.getEmail());
                statement.setObject(4,user.getPassword());
                statement.setObject(5,user.getPhoneNum());
                return statement;
            }
        };
        //创建keyholder
        GeneratedKeyHolder keyHolder=new GeneratedKeyHolder();
        jdbcTemplate.update(creator,keyHolder);
        Long key=keyHolder.getKey().longValue();

       //jdbcTemplate.update("insert into sys_user values(?,?,?,?,?)",
         //      null,user.getUsername(),user.getEmail(),user.getPassword(),user.getPhoneNum());
        return key;
    }

    @Override
    public void saveUserRoleRel(Long id, long[] roleIds) {
        for(int i=0;i<roleIds.length;i++)
      jdbcTemplate.update("insert into sys_user_role values(?,?)",id,roleIds[i]);
    }

    @Override
    public void delUserRoleRel(Long userId) {
         jdbcTemplate.update("delete from sys_user_role where userId=?",userId);
    }

    @Override
    public void del(Long userId) {
       jdbcTemplate.update("delete from sys_user where id=?",userId);
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) throws EmptyResultDataAccessException {
        User user = jdbcTemplate.queryForObject("select *from sys_user where username=?&&password=?",
                new BeanPropertyRowMapper<>(User.class),username, password);
        return user;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}


