package com.capgemini.omnichannel.security;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.capgemini.omnichannel.security.SecurityMSApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SecurityMSApplication.class)
@WebAppConfiguration
public class SecurityMSApplicationTest {

	@Test
	public void contextLoads() {
	}

}
