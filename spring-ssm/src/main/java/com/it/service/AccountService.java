package com.it.service;

import com.it.domain.Account;

import java.util.List;

public interface AccountService {

    public  void save(Account account);

    public List<Account>findAll();
}
