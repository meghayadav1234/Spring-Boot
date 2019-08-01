package com.yash.SpringBootMvc.Exception;

public class CustomValidationException  extends RuntimeException{

	private String message;
	
	public String getMessage() {
		return message;
	}

	public CustomValidationException(String message) {
		super(message);
		this.message = message;
	}
	/*
	model and view-home controller
	put and delete
	error page-exception*/
	/*Distributed transaction mgnt
	@transactional internal working , different db connection,jpa,*/

	//ACID Property
	//Difference between jpa and hibernate
}
