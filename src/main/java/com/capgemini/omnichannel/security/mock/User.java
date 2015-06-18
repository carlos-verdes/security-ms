package com.capgemini.omnichannel.security.mock;

public class User{
	private String id;
	private String password;
	
	
	@Override
	public String toString() {
		return "User [id" + id + ", password=" + password + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
