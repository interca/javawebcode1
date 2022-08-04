package com.it.service;

import com.it.domain.Account;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface AccountService {


    public  void save(Account account);


    public List<Account>findAll();
}
