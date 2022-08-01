package com.it.springbootprofiles;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest(classes =SpringbootProfilesApplication.class)
class SpringbootProfilesApplicationTests {

	@Autowired
	private  play p;
	@Test
	void contextLoads() {
        p.save();
	}

}
