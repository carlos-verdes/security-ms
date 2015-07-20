package com.capgemini.omnichannel.security.service.config;

import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.impl.crypto.RsaProvider;

import java.security.KeyPair;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration()
@ComponentScan({ "com.capgemini.omnichannel.security.service" })
public class ServiceConfiguration {

	@Bean
	KeyPair rsaKeyPair() {
		return RsaProvider.generateKeyPair();
	}

	@Bean
	JwtParser jwsParser() {
		KeyPair keyPair = rsaKeyPair();
		JwtParser parser = Jwts.parser().setSigningKey(keyPair.getPublic());
		return parser;
	}
}
