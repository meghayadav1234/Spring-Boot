package com.yash.SpringBootMvc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yash.SpringBootMvc.Exception.CustomValidationException;
import com.yash.SpringBootMvc.dto.StudentDTO;

@RestController
@RequestMapping("/student")
public class StudentController {

	private List<StudentDTO> studentDTOs = new ArrayList<StudentDTO>();
	
	@GetMapping("/details/{id}")
	public StudentDTO getStudentDetails(@PathVariable("id") Integer id){
		
		/*StudentDTO studentDTO = new StudentDTO();
		studentDTO.setStudentId(1);
		studentDTO.setStudentName("Megha");
		studentDTO.setAddress("Pune");
		if(id == 1){
			return studentDTO;
		}
		return null;*/
		StudentDTO studentDTO = new StudentDTO();
		studentDTOs.forEach(x->{
			if(x.getStudentId()	== id){
				studentDTO.setStudentName(x.getStudentName());
				studentDTO.setAddress(x.getAddress());
				studentDTO.setStudentId(x.getStudentId());
			}
		});
		System.out.println("Details added");
		System.out.println(studentDTO);
		return studentDTO;
	}
	
	
	@GetMapping("/details")
	public StudentDTO getStudentDetailsById(@RequestParam Integer id){
		
		/*StudentDTO studentDTO = new StudentDTO();
		studentDTO.setStudentId(1);
		studentDTO.setStudentName("Megha");
		studentDTO.setAddress("Pune");
		if(id == 1){
			return studentDTO;
		}
		return null;*/
		
		StudentDTO studentDTO = new StudentDTO();
		studentDTOs.forEach(x->{
			if(x.getStudentId()	== id){
				studentDTO.setStudentName(x.getStudentName());
				studentDTO.setAddress(x.getAddress());
				studentDTO.setStudentId(x.getStudentId());
			}
		});
		System.out.println("Details added");
		return studentDTO;
	}
	
	@PostMapping("/create")
	public void createStudent(@RequestBody @Valid StudentDTO studentDTO,BindingResult result){
		System.out.println(studentDTO);
		if(result.hasErrors()){
			throw new CustomValidationException(result.getFieldError().getDefaultMessage());
		}else{
			studentDTOs.add(studentDTO);
		}
	}
	
	@PutMapping("/detailsUpdate/{id}")
	public List<StudentDTO> updateStudentDetailsById(@PathVariable("id") Integer id,@RequestBody @Valid StudentDTO studentDTO,BindingResult result){
		System.out.println(studentDTOs);
		studentDTOs.forEach(x->{
			if(x.getStudentId()	== id){
				x.setStudentName(studentDTO.getStudentName());
				x.setAddress(studentDTO.getAddress());
			}else{
				if(result.hasErrors()){
					throw new CustomValidationException(result.getFieldError().getDefaultMessage());
				}
			}
		});
		
		return studentDTOs;
	}
	
	@DeleteMapping("/deleteDetail/{id}")
	public List<StudentDTO> deleteStudentDetailsById(@PathVariable("id") Integer id){
		System.out.println(studentDTOs);
		
		studentDTOs.removeIf(x -> x.getStudentId()==id); 

		/*studentDTOs.forEach(x->{
			if(x.getStudentId()	== id){
				x.setStudentName(studentDTO.getStudentName());
				x.setAddress(studentDTO.getAddress());
			}else{
				if(result.hasErrors()){
					throw new CustomValidationException(result.getFieldError().getDefaultMessage());
				}
			}
		});*/
		System.out.println(studentDTOs);
		return studentDTOs;
	}
}
