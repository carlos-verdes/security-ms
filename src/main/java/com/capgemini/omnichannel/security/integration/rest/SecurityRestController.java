package com.capgemini.omnichannel.security.integration.rest;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;

import java.security.Principal;

import javax.crypto.SecretKey;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController("token")
@RequestMapping("/token")

/**
 * Based on JSON Token Authentication
 * @author cinfante
 *
 */
//TODO change exception handle using @ControllerAdvice
public class SecurityRestController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ResponseEntity<String> getToken(Principal principal){
		String token = null;
		
		try{
			String user = principal.getName();
			logger.trace(String.format("Received token request for user %s", user));
			token = generateToken(user);
			logger.trace(String.format("Generated Token: %s", token));
		} catch(NullPointerException npe){
			logger.error(npe.getCause().getMessage());
			logger.error("Impossible to get the logged user");
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
			
		return new ResponseEntity<String>(token, HttpStatus.OK);
	}
	
	@RequestMapping(value="/demo", method=RequestMethod.GET)
	public String demo(){
		return "demo OK";
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
