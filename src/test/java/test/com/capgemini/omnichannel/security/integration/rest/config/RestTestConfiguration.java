package test.com.capgemini.omnichannel.security.integration.rest.config;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.capgemini.omnichannel.security.service.TokenService;

@Configuration()
@ComponentScan({ "com.capgemini.omnichannel.security.integration.rest",
		"com.capgemini.omnichannel.common.integration.rest" })
@EnableWebMvc()
public class RestTestConfiguration {

	@Bean
	public TokenService mockTokenService() {
		TokenService mock = Mockito.mock(TokenService.class);

		return mock;
	}

}
