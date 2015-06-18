package com.capgemini.omnichannel.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class SecurityMSApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityMSApplication.class, args);
	}
}
