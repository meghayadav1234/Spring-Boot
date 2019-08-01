package com.yash.SpringBootMvc.Exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class GlobalRestControllerExceptionHandler {

/*	@ExceptionHandler(CustomBusinessException.class)
	public ResponseEntity<ErrorDeatils> handleBusinessException(CustomBusinessException customBusinessException){
		ErrorDeatils errorDetails =new ErrorDeatils();
		errorDetails.setMessage(customBusinessException.getMessage());
		errorDetails.setStatusCode(HttpStatus.BAD_REQUEST.value());
		ResponseEntity<ErrorDeatils> responseEntity = new ResponseEntity<ErrorDeatils>(errorDetails,HttpStatus.BAD_REQUEST);
		return responseEntity;
	}
*/
	/*@ExceptionHandler(CustomValidationException.class)
	public ResponseEntity<ErrorDeatils> handleValidationException(CustomValidationException customBusinessException){
		ErrorDeatils errorDetails =new ErrorDeatils();
		errorDetails.setMessage(customBusinessException.getMessage());
		errorDetails.setStatusCode(HttpStatus.BAD_REQUEST.value());
		ResponseEntity<ErrorDeatils> responseEntity = new ResponseEntity<ErrorDeatils>(errorDetails,HttpStatus.BAD_REQUEST);
		return responseEntity;
	}*/
	
	@ExceptionHandler(CustomValidationException.class)                                                                                                                                               
	public ModelAndView handleValidationException(CustomValidationException customBusinessException,Model model){
		ModelAndView modelAndView = new ModelAndView();
		model.addAttribute("errorMessage",customBusinessException.getMessage() +" Status Code" + HttpStatus.BAD_REQUEST.value());
		modelAndView.setViewName("errorPage");
		return modelAndView;
		//return "Exception";
	}
}
