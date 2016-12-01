package com.jeffinjude.springbootsample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeffinjude.springbootsample.dao.StudentDao;
import com.jeffinjude.springbootsample.entity.Student;
import com.jeffinjude.springbootsample.entity.Students;

@Service
public class StudentService {
	
	@Autowired
	private StudentDao studentDao;
	
	public Students getAllStudents(){
        return this.studentDao.getAllStudents();
    }
	
	public Student getStudentById(int id){
		return this.studentDao.getStudentById(id);
	}
	
	public void removeStudentById(int id){
		this.studentDao.removeStudentById(id);
	}
	
	public void updateStudent(Student student){
		this.studentDao.updateStudent(student);
	}
	
	public void insertStudent(Student student){
		this.studentDao.insertStudent(student);
	}
}
