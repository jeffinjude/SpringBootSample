package com.jeffinjude.springbootsample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.jeffinjude.springbootsample.dao.StudentDao;
import com.jeffinjude.springbootsample.entity.Student;
import com.jeffinjude.springbootsample.entity.Students;

@Service
public class StudentService {
	
	@Autowired
	@Qualifier("mongoData")
	private StudentDao studentDaoImpl;
	
	public Students getAllStudents(){
        return this.studentDaoImpl.getAllStudents();
    }
	
	public Student getStudentById(int id){
		return this.studentDaoImpl.getStudentById(id);
	}
	
	public void removeStudentById(int id){
		this.studentDaoImpl.removeStudentById(id);
	}
	
	public void updateStudent(Student student){
		this.studentDaoImpl.updateStudent(student);
	}
	
	public void insertStudent(Student student){
		this.studentDaoImpl.insertStudent(student);
	}
}
