package com.capgemini.omnichannel.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.capgemini.omnichannel.security.service.config.ServiceConfiguration;

@SpringBootApplication
@EnableAutoConfiguration
@Import(ServiceConfiguration.class)
public class SecurityMSApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityMSApplication.class, args);
	}


}
