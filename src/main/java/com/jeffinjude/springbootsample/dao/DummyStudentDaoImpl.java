package com.jeffinjude.springbootsample.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.jeffinjude.springbootsample.entity.Student;
import com.jeffinjude.springbootsample.entity.Students;

@Repository
@Qualifier("fakeData")
public class DummyStudentDaoImpl implements StudentDao{
	
	private static List<Student> students = new ArrayList<Student>();
	
	static{
			students.add(new Student(0, "Student0", "Computer Science"));
			students.add(new Student(1, "Student1", "Physics"));
			students.add(new Student(2, "Student2", "Maths"));
		  }
	
	
	public Students getAllStudents(){
		Students students = new Students();
		students.setStudents((ArrayList<Student>) this.students);
		return students;
    }
	
	public Student getStudentById(int id){
		return this.students.get(id);
	}
	
	public void removeStudentById(int id){
		this.students.remove(id);
	}
	
	public void updateStudent(Student student){
		Student s = students.get(student.getStudentId());
		s.setName(student.getName());
		s.setCourse(student.getCourse());
		students.set(student.getStudentId(), student);
	}
	
	public void insertStudent(Student student){
		this.students.add(student);
	}
}
