package com.it.springbootmybaties;

import com.it.springbootmybaties.domain.User;
import com.it.springbootmybaties.mapper.UserMapper;
import com.it.springbootmybaties.mapper.UserXmlMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringbootMybatiesApplicationTests {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private UserXmlMapper userXmlMapper;

	@Test
	public void test(){
		List<User> all = userXmlMapper.findAll();
		System.out.println(all);
	}
	@Test
	void contextLoads() {
		List<User> all = userMapper.findAll();
		System.out.println(all);
	}

}
