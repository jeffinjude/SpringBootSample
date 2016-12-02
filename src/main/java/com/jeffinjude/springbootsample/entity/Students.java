package com.jeffinjude.springbootsample.entity;

import java.util.List;

import com.jeffinjude.springbootsample.entity.Student;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel( value = "Students", description = "Students collection resource representation" )
public class Students {
	@ApiModelProperty(value = "students", required = true)
	private List<Student> students;

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
}
