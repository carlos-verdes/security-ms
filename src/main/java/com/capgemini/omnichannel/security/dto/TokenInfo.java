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

	
	@Override
	public String toString() {
		return "TokenInfo [subject=" + subject + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((subject == null) ? 0 : subject.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TokenInfo other = (TokenInfo) obj;
		if (subject == null) {
			if (other.subject != null)
				return false;
		} else if (!subject.equals(other.subject))
			return false;
		return true;
	}
	
}
