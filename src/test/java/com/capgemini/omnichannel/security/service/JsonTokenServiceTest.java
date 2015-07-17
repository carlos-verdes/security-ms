package com.capgemini.omnichannel.security.service;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.capgemini.omnichannel.security.SecurityMSApplication;
import com.capgemini.omnichannel.security.dto.TokenInfo;
import com.capgemini.omnichannel.security.exception.InvalidTokenException;
import com.capgemini.omnichannel.security.service.impl.JsonTokenServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SecurityMSApplication.class)
public class JsonTokenServiceTest {

	@Autowired
	JsonTokenServiceImpl jsonTokenService;
	
	@Test
	public void testTokenValidation() throws InvalidTokenException{
		
		String user= "userId";
		
		//create a token for a user
		TokenInfo tokenInfo= new TokenInfo(user);
		String token = jsonTokenService.createNewToken(tokenInfo);
		
		//validate token
		tokenInfo= jsonTokenService.validateToken(token);
		
		//get user from token
		String userFromToken = tokenInfo.getSubject();
		
		Assert.assertEquals("User from token is not what expected",user, userFromToken);
		
		
	}
	
}
