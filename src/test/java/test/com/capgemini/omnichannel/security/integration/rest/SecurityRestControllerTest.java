package test.com.capgemini.omnichannel.security.integration.rest;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.security.Principal;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import test.com.capgemini.omnichannel.security.integration.rest.config.RestTestConfiguration;

import com.capgemini.omnichannel.security.dto.TokenInfo;
import com.capgemini.omnichannel.security.exception.InvalidTokenException;
import com.capgemini.omnichannel.security.service.TokenService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { RestTestConfiguration.class })
@WebAppConfiguration
public class SecurityRestControllerTest {

	private static final String REST_PATTERN = "/tokens";

	private MockMvc mockMvc;

	@Autowired
	private TokenService tokenService;

	@Autowired
	private WebApplicationContext webApplicationContext;

	private static final String USER_1 = "user1";
	private static final TokenInfo USER1_TOKEN_INFO = new TokenInfo(USER_1);

	private static final String VALID_TOKEN = "eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJ1c2VySWQifQ.FjweIbIUePW3PBWZvbeWe6uL6VzG6yEi0ltKH5kWYBp-FySOKOJB8KzF8sudhibCXRF_GhHHz_XY9ZaeHtPqZyesNLYXGE4q-s9GK4SSSkkzJpVcouOx9ZpjtBzK_kkGvWSH3eEv3sjNFNsJNPXAgSK4ZFQ153bBpqsbUt_dPrbKj7IXTIxZTAkZjFPXY5x0ES-q8v7azWJb8xx24fsHvGFPPPFHwiQv5jVquZ-uZn11sL3hKfsfQG3S0nkW9sKp4WONxF4gAl3do5QAM7_V6C0-5El4gq--jp0yQaRD49wanuwsKWLfcFCgkrJRSUKdzW37s9_h0gpPRbCUcq7jpNFt0NOxRP-xMU8S-F9ADwS1HttC3LmOW4i45zU8b_62ObQxugIlS2QfG8ivT8EaFRcJHAUNjYTYr6aDHH4es_OIbGA7O8JGGJHWs6HtBHGJJepO9Bqe-Jk7ztMJSyVIwqx66Hp5GOdjyMVx9umDDrcEITKdC_BwQsS6aol3sOz40tdWkrzojIGAxxnDAD4_mTdjzagmRMAuc06LlBYw0X-ITE5tC8hVzCV3KZu8ZJj2sEPV3qvb2xklPak0iQ2um-5Y1RZ9u615ExDnpHC-_rRvP6nMeK46zZVDyvmyYJkc8_SDnS1GHMQz14uJ2RmEVrjMtbsmshJC3WL40Dtyd5Q";
	private static final String INVALID_TOKEN = "badtoken";

	@Before
	public void setUp() throws InvalidTokenException {
		// init mocks
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

		TokenInfo tokenInfo = USER1_TOKEN_INFO;
		// mock general get resources
		when(tokenService.createNewToken(tokenInfo)).thenReturn(VALID_TOKEN);
		when(tokenService.validateToken(VALID_TOKEN)).thenReturn(USER1_TOKEN_INFO);
		when(tokenService.validateToken(INVALID_TOKEN)).thenThrow(new InvalidTokenException(INVALID_TOKEN));

	}

	@Test
	public void testTokenCreationValidationRest() throws Exception {

		String uri = REST_PATTERN;

		Principal user1Principal = new Principal() {

			@Override
			public String getName() {
				return USER_1;
			}
		};

		// with principal
		mockMvc.perform(get(uri).principal(user1Principal)).andExpect(status().isOk())
				.andExpect(jsonPath("$.data").value(VALID_TOKEN));

		mockMvc.perform(put(uri).principal(user1Principal).content(VALID_TOKEN)).andExpect(status().isOk())
				.andExpect(jsonPath("$.data.subject").value(USER_1));

		// without principal
		mockMvc.perform(put(uri).principal(user1Principal).content(INVALID_TOKEN)).andExpect(status().isUnauthorized());

	}
}
