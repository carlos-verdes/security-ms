package com.capgemini.omnichannel.security.service.impl;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;

import java.security.Principal;
import java.util.List;

import javax.crypto.SecretKey;

import com.capgemini.omnichannel.security.service.TokenService;

public class JsonTokenServiceImpl implements TokenService {


	@Override
	public String getResourceId(String resource) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getResources(Principal principal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getResourceById(String id, Principal principal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends String> S updateResource(String id, S value, Principal principal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends String> S insertResource(String id, S value, Principal principal) {
		// TODO Auto-generated method stub
		return null;
	}


	
	/**
	 * Generates a token from the string received
	 * @param user
	 * @return
	 */
	private String generateToken(String user) {
		String token;
		
		SecretKey key = MacProvider.generateKey();
		token = Jwts.builder().setSubject(user).signWith(SignatureAlgorithm.HS512, key).compact();
		
		return token;
	}

}
