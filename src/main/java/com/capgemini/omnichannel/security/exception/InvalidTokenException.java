package com.capgemini.omnichannel.security.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "Invalid security token")
public class InvalidTokenException extends Exception{
	private static final long serialVersionUID = -49039459184139579L;

	private static String MESSAGE_FORMAT="Invalid token %s";
	
	public InvalidTokenException(String token, Throwable cause) {
		super(String.format(MESSAGE_FORMAT, token), cause);
	}

	public InvalidTokenException(String token) {
		super(String.format(MESSAGE_FORMAT, token));
	}

	
	
	
}
