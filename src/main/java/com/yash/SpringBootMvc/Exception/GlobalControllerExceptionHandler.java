package com.yash.SpringBootMvc.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@ControllerAdvice
public class GlobalControllerExceptionHandler {

	@ExceptionHandler(CustomBusinessException.class)
	public ResponseEntity<ErrorDeatils> handleBusinessException(CustomBusinessException customBusinessException){
		ErrorDeatils errorDetails =new ErrorDeatils();
		errorDetails.setMessage(customBusinessException.getMessage());
		errorDetails.setStatusCode(HttpStatus.BAD_REQUEST.value());
		ResponseEntity<ErrorDeatils> responseEntity = new ResponseEntity<ErrorDeatils>(errorDetails,HttpStatus.BAD_REQUEST);
		return responseEntity;
	}

	@ExceptionHandler(CustomValidationException.class)
	public ResponseEntity<ErrorDeatils> handleValidationException(CustomValidationException customBusinessException){
		ErrorDeatils errorDetails =new ErrorDeatils();
		errorDetails.setMessage(customBusinessException.getMessage());
		errorDetails.setStatusCode(HttpStatus.BAD_REQUEST.value());
		ResponseEntity<ErrorDeatils> responseEntity = new ResponseEntity<ErrorDeatils>(errorDetails,HttpStatus.BAD_REQUEST);
		return responseEntity;
	}
}
