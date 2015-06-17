package com.capgemini.omnichannel.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class SecurityMSApplication {

	public static void main(String[] args) {
		//System.setProperty("java.net.preferIPv4Stack" , "true");
		SpringApplication.run(SecurityMSApplication.class, args);
	}
}
