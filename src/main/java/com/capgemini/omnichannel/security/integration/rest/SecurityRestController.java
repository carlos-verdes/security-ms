package com.capgemini.omnichannel.security.integration.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.omnichannel.common.integration.rest.BaseResourceRestController;
import com.capgemini.omnichannel.common.model.service.ResourcePersistenceService;
import com.capgemini.omnichannel.security.service.TokenService;

@RestController("tokens")
@RequestMapping("/tokens")

/**
 * Based on JSON Token Authentication
 * @author cinfante
 *
 */
public class SecurityRestController extends BaseResourceRestController<String>{
	
	//	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private TokenService tokenService;

	@Override
	protected ResourcePersistenceService<String> getResourcePersistenceService() {
		return this.tokenService;
	}

	public TokenService getTokenService() {
		return tokenService;
	}

	public void setTokenService(TokenService tokenService) {
		this.tokenService = tokenService;
	}
}
