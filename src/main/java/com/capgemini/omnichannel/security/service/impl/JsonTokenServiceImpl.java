package com.capgemini.omnichannel.security.service.impl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;
import io.jsonwebtoken.impl.crypto.RsaProvider;
import io.jsonwebtoken.impl.crypto.RsaSignatureValidator;

import java.security.KeyPair;
import java.security.Principal;
import java.security.interfaces.RSAKey;
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
	 * 
	 * @param user
	 * @return
	 */
	private static String generateToken(String user) {
		String token;
		KeyPair keyPair = RsaProvider.generateKeyPair();
		System.out.println(String.format("private key \n %s", keyPair.getPrivate().toString()));
		System.out.println(String.format("public key \n %s", keyPair.getPrivate().toString()));

		token = Jwts.builder().setSubject(user).signWith(SignatureAlgorithm.RS256, keyPair.getPrivate()).compact();

		Jws<Claims> parsedtoken = Jwts.parser().setSigningKey(keyPair.getPublic()).parseClaimsJws(token);

		System.out.println(String.format("subject: %s", parsedtoken.getBody().getSubject()));

		return token;
	}

	public static void main(String[] args) {
		
		String user="cinfantes";
		
		generateToken(user);
	}
	
}
