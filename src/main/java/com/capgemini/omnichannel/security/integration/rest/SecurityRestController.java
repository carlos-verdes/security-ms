package com.capgemini.omnichannel.security.integration.rest;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.omnichannel.common.integration.rest.dto.BaseRestDTO;
import com.capgemini.omnichannel.security.dto.TokenInfo;
import com.capgemini.omnichannel.security.exception.InvalidTokenException;
import com.capgemini.omnichannel.security.service.TokenService;

/**
 * Based on JSON Token Authentication
 * 
 * @author cinfante
 *
 */
@RestController("tokens")
@RequestMapping("/tokens")
public class SecurityRestController {

	// private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private TokenService tokenService;

	@RequestMapping(method = RequestMethod.GET)
	public BaseRestDTO<String> getNewToken(Principal principal) {

		TokenInfo tokenInfo = new TokenInfo(principal.getName());
		String token = tokenService.createNewToken(tokenInfo);

		return new BaseRestDTO<String>(token);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public BaseRestDTO<TokenInfo> validateToken(@RequestBody String token, Principal principal)
			throws InvalidTokenException {

		TokenInfo tokenInfo = tokenService.validateToken(token);

		return new BaseRestDTO<TokenInfo>(tokenInfo);
	}

	public TokenService getTokenService() {
		return tokenService;
	}

	public void setTokenService(TokenService tokenService) {
		this.tokenService = tokenService;
	}
}
