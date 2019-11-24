package com.ujwal.model;

import java.io.Serializable;

public class ApiResponse<T> implements Serializable {

	private static final long serialVersionUID = -4078132343171278239L;
	private int status;
    private String message;
    private Object result;
    
    public ApiResponse() {
		// TODO Auto-generated constructor stub
	}

	public ApiResponse(int status, String message, Object result) {
		super();
		this.status = status;
		this.message = message;
		this.result = result;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

}
