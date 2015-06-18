package com.capgemini.omnichannel.security.mock;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@ConfigurationProperties(prefix="usersMock")
public class UsersValidationService implements UserDetailsService{
	private Map<String,User> users;

	@Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
      User user = users.get(id);
      if(user != null) {
    	  return new org.springframework.security.core.userdetails.User(
    			  	user.getId(), user.getPassword(), true, true, true, true,
    			  	AuthorityUtils.createAuthorityList("USER"));
      } else {
        throw new UsernameNotFoundException("could not find the user '" + id + "'");
      }
    }

	@Override
	public String toString() {
		return "Users [users=" + users + "]";
	}
	
	public Map<String, User> getUsers() {
		return users;
	}
	public void setUsers(Map<String, User> users) {
		this.users = users;
	}
}
