package com.yash.SpringBootMvc.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class StudentDTO {

	@NotNull(message= "Student Name not null")
	@Size(max = 10, min = 5,message = "Name size should be in between length 5 and 10")
	private String studentName;
	
	@NotNull(message= "Student Id not null")
	private Integer studentId;
	
	@Size(max = 100, min = 5,message = "Address size should be in between length 5 and 100")
	private String address;

	@Override
	public String toString() {
		return "StudentDTO [studentName=" + studentName + ", studentId=" + studentId + ", address=" + address + "]";
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
