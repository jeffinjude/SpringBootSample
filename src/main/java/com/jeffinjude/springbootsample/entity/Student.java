package com.jeffinjude.springbootsample.entity;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel( value = "Student", description = "Student resource representation" )
public class Student {
	
	@ApiModelProperty(value = "id", required = true)
	private int id;
	@ApiModelProperty(value = "name", required = true)
	private String name;
	@ApiModelProperty(value = "course", required = true)
	private String course;
	
	public Student()
	{
		
	}
	
	public Student(int id, String name, String course) {
		this.id = id;
		this.name = name;
		this.course = course;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
