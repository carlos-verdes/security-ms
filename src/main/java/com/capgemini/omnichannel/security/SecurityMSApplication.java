package com.capgemini.omnichannel.security;

import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.impl.crypto.RsaProvider;

import java.security.KeyPair;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableAutoConfiguration
public class SecurityMSApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityMSApplication.class, args);
	}

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
