package com.it.service.impl;

import com.it.domain.Account;
import com.it.mapper.AccountMapper;
import com.it.service.AccountService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
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
