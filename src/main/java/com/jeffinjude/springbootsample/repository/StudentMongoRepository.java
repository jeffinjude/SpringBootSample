package com.jeffinjude.springbootsample.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.jeffinjude.springbootsample.entity.Student;
//NOTE: Since mongo template is used MongoRepository is not needed
public interface StudentMongoRepository extends MongoRepository<Student, String> {

}
