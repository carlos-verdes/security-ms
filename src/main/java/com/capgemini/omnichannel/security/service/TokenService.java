package com.capgemini.omnichannel.security.service;

import com.capgemini.omnichannel.security.dto.TokenInfo;
import com.capgemini.omnichannel.security.exception.InvalidTokenException;


public interface TokenService {
	
	public String createNewToken(TokenInfo tokenInfo);
	
	public TokenInfo validateToken(String token)throws InvalidTokenException;

}
