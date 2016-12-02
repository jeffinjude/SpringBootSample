package com.jeffinjude.springbootsample.controller;

import java.net.HttpURLConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jeffinjude.springbootsample.entity.Student;
import com.jeffinjude.springbootsample.entity.Students;
import com.jeffinjude.springbootsample.service.StudentService;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponses;
import com.wordnik.swagger.annotations.ApiParam;

import com.wordnik.swagger.annotations.ApiResponse;

@Api(basePath = "/student-api", value = "Student", description = "Operations with student", produces = "application/json")
@RestController
@RequestMapping("/student-api")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	/*STUDENT LIST****************************************************************************************************************************/
	@RequestMapping(value="/student-list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Get all student details",
			notes = "This api operation fetches all the students details.",
			response = Students.class,
			responseContainer = "List"
		)
	@ApiResponses(value = {
	    @ApiResponse(code = HttpURLConnection.HTTP_OK, message = "Success. Returns the list of students", response = Students.class),
	    @ApiResponse(code = HttpURLConnection.HTTP_UNAUTHORIZED, message = "Unauthorized Access"),
	    @ApiResponse(code = HttpURLConnection.HTTP_NOT_FOUND, message = "Not found"),
	    @ApiResponse(code = HttpURLConnection.HTTP_INTERNAL_ERROR, message = "Internal server problems")
	})	
	public Students getAllStudents(){
        return studentService.getAllStudents();
    }
	
	/*STUDENT DETAILS****************************************************************************************************************************/
	@RequestMapping(value="/student-fetch/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Get specific student details",
		notes = "This api operation fetches specific students details based on student id.",
		response = Student.class
	)
	@ApiResponses(value = {
	@ApiResponse(code = HttpURLConnection.HTTP_OK, message = "Success. Returns details of a student", response = Student.class),
	@ApiResponse(code = HttpURLConnection.HTTP_UNAUTHORIZED, message = "Unauthorized Access"),
	@ApiResponse(code = HttpURLConnection.HTTP_NOT_FOUND, message = "Not found"),
	@ApiResponse(code = HttpURLConnection.HTTP_INTERNAL_ERROR, message = "Internal server problems")
	})
	public Student getStudentById(@ApiParam(value = "Id of student that should be fetched", required = true) @PathVariable("id") int id){
        return studentService.getStudentById(id);
    }
	
	/*INSERT STUDENT****************************************************************************************************************************/
	@RequestMapping(value="/student-insert/{id}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Insert student details",
		notes = "Provide student details in json format to insert it into the database."
		)
	@ApiResponses(value = {
	    @ApiResponse(code = HttpURLConnection.HTTP_OK, message = "Success"),
	    @ApiResponse(code = HttpURLConnection.HTTP_UNAUTHORIZED, message = "Unauthorized Access"),
	    @ApiResponse(code = HttpURLConnection.HTTP_BAD_REQUEST, message = "Invalid Json"),
	    @ApiResponse(code = HttpURLConnection.HTTP_NOT_FOUND, message = "Not found"),
	    @ApiResponse(code = HttpURLConnection.HTTP_INTERNAL_ERROR, message = "Internal server problems")
	})
	public void insertStudent(@ApiParam(value = "Details of student in Json format", required = true) @RequestBody Student student){
        studentService.insertStudent(student);
    }
	
	/*UPDATE STUDENT****************************************************************************************************************************/
	@RequestMapping(value="/student-update/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Update student details",
	notes = "This api operation is used to update the details of a specific student."
	)
	@ApiResponses(value = {
	    @ApiResponse(code = HttpURLConnection.HTTP_OK, message = "Success"),
	    @ApiResponse(code = HttpURLConnection.HTTP_UNAUTHORIZED, message = "Unauthorized Access"),
	    @ApiResponse(code = HttpURLConnection.HTTP_BAD_REQUEST, message = "Invalid Json"),
	    @ApiResponse(code = HttpURLConnection.HTTP_NOT_FOUND, message = "Not found"),
	    @ApiResponse(code = HttpURLConnection.HTTP_INTERNAL_ERROR, message = "Internal server problems")
	})
	public void updateStudent(@ApiParam(value = "Details of student in Json format. Provide the correct existing student id of the student whose details need to be updated.", required = true) @RequestBody Student student){
        studentService.updateStudent(student);
    }
	
	/*DELETE STUDENT****************************************************************************************************************************/
	@RequestMapping(value="/student-delete/{id}", method = RequestMethod.DELETE)
	@ApiOperation(value = "Delete a student",
	notes = "This api operation deletes student details of the given student id."
	)
	@ApiResponses(value = {
	    @ApiResponse(code = HttpURLConnection.HTTP_OK, message = "Success"),
	    @ApiResponse(code = HttpURLConnection.HTTP_UNAUTHORIZED, message = "Unauthorized Access"),
	    @ApiResponse(code = HttpURLConnection.HTTP_BAD_REQUEST, message = "Invalid Json"),
	    @ApiResponse(code = HttpURLConnection.HTTP_NOT_FOUND, message = "Not found"),
	    @ApiResponse(code = HttpURLConnection.HTTP_INTERNAL_ERROR, message = "Internal server problems")
	})
	public void removeStudentById(@ApiParam(value = "Id of student that should be deleted", required = true) @PathVariable("id") int id){
        studentService.removeStudentById(id);
    }
	
}
