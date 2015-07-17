package com.capgemini.omnichannel.security.dto;

import java.io.Serializable;

public class TokenInfo implements Serializable{
	private static final long serialVersionUID = 6307656294526250068L;

	String subject;

	public TokenInfo() {
		super();
	}

	public TokenInfo(String subject) {
		super();
		this.subject = subject;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
}
