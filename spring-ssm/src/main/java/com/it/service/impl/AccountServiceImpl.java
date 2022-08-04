package com.it.service.impl;

import com.it.domain.Account;
import com.it.mapper.AccountMapper;
import com.it.service.AccountService;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountMapper mapper;
    @Override
    public void save(Account account) {
       mapper.save(account);
    }

    @Override
    public List<Account> findAll() {
        List<Account> all = mapper.findAll();
        return all;
    }
}
