package com.ujwal.model;

public class AuthToken {

	String userName;
	String token;
	
	public AuthToken() {
		// for JSON
	}

	public AuthToken(String userName, String token) {
		super();
		this.userName = userName;
		this.token = token;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
}
