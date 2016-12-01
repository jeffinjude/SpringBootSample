package com.jeffinjude.springbootsample.entity;

import java.util.ArrayList;

import com.jeffinjude.springbootsample.entity.Student;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel( value = "Students", description = "Students collection resource representation" )
public class Students {
	@ApiModelProperty(value = "students", required = true)
	private ArrayList<Student> students;

	public ArrayList<Student> getStudents() {
		return students;
	}

	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}
}
