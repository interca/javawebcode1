package com.it.mapper;

import com.it.domain.Account;

import java.util.List;

public interface AccountMapper {
    public  void save(Account account);

    public List<Account>findAll();
}
