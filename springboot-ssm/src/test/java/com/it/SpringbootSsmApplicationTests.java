package com.it;

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

}
