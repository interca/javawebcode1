package com.it;

import com.it.domain.Account;
import com.it.mapper.AccountMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootSsmApplicationTests {
	@Autowired
	private AccountMapper accountMapper;

	@Test
	void contextLoads() {
		System.out.println(accountMapper.findAll());
	}

	@Test
	void test2(){
		Account account=new Account();
		account.setId(2);
		System.out.println(accountMapper.findById(account));
	}

}
