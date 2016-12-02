package com.jeffinjude.springbootsample.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.jeffinjude.springbootsample.entity.Student;

public interface StudentMongoRepository extends MongoRepository<Student, String> {

}
