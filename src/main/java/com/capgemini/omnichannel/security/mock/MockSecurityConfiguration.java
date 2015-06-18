package com.capgemini.omnichannel.security.mock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
public class MockSecurityConfiguration extends GlobalAuthenticationConfigurerAdapter {
	@Autowired
	private UserDetailsService userDetailService;

	@Override
	public void init(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(getUserDetailService());
	}

	public UserDetailsService getUserDetailService() {
		return userDetailService;
	}

	public void setUserDetailService(UserDetailsService userDetailService) {
		this.userDetailService = userDetailService;
	}
}
