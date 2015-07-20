package test.com.capgemini.omnichannel.security.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.capgemini.omnichannel.security.dto.TokenInfo;
import com.capgemini.omnichannel.security.exception.InvalidTokenException;
import com.capgemini.omnichannel.security.service.TokenService;
import com.capgemini.omnichannel.security.service.config.ServiceConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ServiceConfiguration.class)
public class JsonTokenServiceTest {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	TokenService jsonTokenService;

	@Test
	public void testTokenValidation() throws InvalidTokenException {

		String user = "userId";
		logger.info(String.format("Testing token creation/validation for user %s", user));

		// create a token for a user
		TokenInfo tokenInfo = new TokenInfo(user);
		String token = jsonTokenService.createNewToken(tokenInfo);
		logger.info(String.format("Token generated: \n%s", token));

		// validate token
		tokenInfo = jsonTokenService.validateToken(token);

		// get user from token
		String userFromToken = tokenInfo.getSubject();
		logger.info(String.format("User from token: %s", userFromToken));

		Assert.assertEquals("User from token is not what expected", user, userFromToken);

	}

}
