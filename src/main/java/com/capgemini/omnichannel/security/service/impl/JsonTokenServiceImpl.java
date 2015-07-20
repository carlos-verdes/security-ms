package com.capgemini.omnichannel.security.service.impl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

import java.security.KeyPair;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.omnichannel.security.dto.TokenInfo;
import com.capgemini.omnichannel.security.exception.InvalidTokenException;
import com.capgemini.omnichannel.security.service.TokenService;
import com.capgemini.omnichannel.security.util.SecurityUtils;

@Service
public class JsonTokenServiceImpl implements TokenService {

	@Autowired
	private KeyPair rsaKeyPair;

	@Autowired
	private JwtParser jwsParser;

	@Override
	public String createNewToken(TokenInfo tokenInfo) {
		String token = null;

		if (tokenInfo != null && tokenInfo.getSubject() != null) {
			token = Jwts.builder().setSubject(tokenInfo.getSubject())
					.signWith(SignatureAlgorithm.RS256, rsaKeyPair.getPrivate()).compact();
		}

		return token;
	}

	@Override
	public TokenInfo validateToken(String token) throws InvalidTokenException {

		Jws<Claims> jwsClaims;
		try {
			jwsClaims = Jwts.parser().setSigningKey(rsaKeyPair.getPublic()).parseClaimsJws(token);
		} catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException | SignatureException
				| IllegalArgumentException e) {
			throw new InvalidTokenException(token, e);
		}

		TokenInfo tokenInfo = SecurityUtils.createTokeninfoFromJws(jwsClaims);
		return tokenInfo;
	}

	public KeyPair getRsaKeyPair() {
		return rsaKeyPair;
	}

	public void setRsaKeyPair(KeyPair rsaKeyPair) {
		this.rsaKeyPair = rsaKeyPair;
	}

}
