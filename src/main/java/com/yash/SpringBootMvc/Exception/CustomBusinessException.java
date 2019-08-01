package com.yash.SpringBootMvc.Exception;

public class CustomBusinessException extends RuntimeException{

	private String message;
	
	public CustomBusinessException(String message) {
		super(message);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	

}
