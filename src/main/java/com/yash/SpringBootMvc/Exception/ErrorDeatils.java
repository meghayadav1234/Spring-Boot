package com.yash.SpringBootMvc.Exception;

public class ErrorDeatils {

	private String message;
	
	private Integer statusCode;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer i) {
		this.statusCode = i;
	}
	
	
}
