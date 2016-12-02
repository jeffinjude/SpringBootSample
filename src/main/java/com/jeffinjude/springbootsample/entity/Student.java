package com.jeffinjude.springbootsample.entity;

import java.math.BigInteger;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel( value = "Student", description = "Student resource representation" )
@Document(collection = "Student")
public class Student {
	
	@ApiModelProperty(value = "studentId", required = true)
	private int studentId;
	@ApiModelProperty(value = "name", required = true)
	private String name;
	@ApiModelProperty(value = "course", required = true)
	private String course;
	
	public Student()
	{
		
	}
	
	public Student(int id, String name, String course) {
		this.studentId = id;
		this.name = name;
		this.course = course;
	}
	
	
	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
}
