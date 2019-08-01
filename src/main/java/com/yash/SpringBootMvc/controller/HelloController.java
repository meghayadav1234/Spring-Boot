package com.yash.SpringBootMvc.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.yash.SpringBootMvc.Exception.CustomValidationException;

@Controller
@RequestMapping("/home")
public class HelloController {
	
	@GetMapping("/hello")
	public String sayHello(){
		return "hello";
		
	}

	@GetMapping("/hi")
	public ModelAndView sayHi(Model model,Locale locale){
		
		ModelAndView modelAndView = new ModelAndView();
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("formattedDate",formattedDate);
		modelAndView.setViewName("hello");
		return modelAndView;
	}
	
	@GetMapping("/checkException")
	public void checkException(@RequestParam Integer id){
		
		if(id == 1){
			throw new CustomValidationException("Custom Check Exception...........");
		}
	}
}
