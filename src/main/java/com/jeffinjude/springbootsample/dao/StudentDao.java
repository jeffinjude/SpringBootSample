package com.jeffinjude.springbootsample.dao;

import com.jeffinjude.springbootsample.entity.Student;
import com.jeffinjude.springbootsample.entity.Students;

public interface StudentDao {
	public Students getAllStudents();
	public Student getStudentById(int id);
	public void removeStudentById(int id);
	public void updateStudent(Student student);
	public void insertStudent(Student student);
}
