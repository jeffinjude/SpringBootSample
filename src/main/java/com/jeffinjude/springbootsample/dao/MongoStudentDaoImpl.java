package com.jeffinjude.springbootsample.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.jeffinjude.springbootsample.entity.Student;
import com.jeffinjude.springbootsample.entity.Students;
import com.jeffinjude.springbootsample.repository.StudentMongoRepository;
import com.jeffinjude.springbootsample.dao.StudentDao;
import org.springframework.data.mongodb.core.MongoTemplate;

@Repository
@Qualifier("mongoData")
public class MongoStudentDaoImpl implements StudentDao{

	@Autowired
	private StudentMongoRepository studentMongoRepository;
	
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	@Override
	public Students getAllStudents() {
		Students students = new Students();
		students.setStudents(mongoTemplate.findAll(Student.class));
		return students;
	}

	@Override
	public Student getStudentById(int id) {
		return mongoTemplate.findOne(new Query(Criteria.where("studentId").is(id)), Student.class);
	}

	@Override
	public void removeStudentById(int id) {
		mongoTemplate.remove(new Query(Criteria.where("studentId").is(id)), Student.class);
	}

	@Override
	public void updateStudent(Student student) {
		Update update=new Update();
		update.set("studentId",student.getStudentId());
		update.set("name",student.getName());
		update.set("course",student.getCourse());
		mongoTemplate.updateFirst(new Query(Criteria.where("studentId").is(student.getStudentId())), update, Student.class);
	}

	@Override
	public void insertStudent(Student student) {
		mongoTemplate.save(student);
	}

}
