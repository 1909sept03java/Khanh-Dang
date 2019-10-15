package com.revature.bootdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.bootdemo.model.Students;
import com.revature.bootdemo.service.StudentsService;

@RestController // @RestController = @Controller + @ResponseBody
@RequestMapping(value = "/student")// end point for student data
public class StudentsController 
{
	private StudentsService studentService;

	@Autowired
	private void setStudentService (StudentsService studentService) {
		this.studentService = studentService;
	}

	// get all students
	@RequestMapping(value = "/all", method = RequestMethod.GET) // parameterize the path
	public ResponseEntity<List<Students>> getAll() {
		return new ResponseEntity<>(this.studentService.getAll(), HttpStatus.OK);
	}

	// get all students by id
	@RequestMapping(value = "/{id}", method = RequestMethod.GET) // parameterize the path
	public ResponseEntity<Students> getStudentById(@PathVariable int id) {
		Students s = this.studentService.getById(id);
		System.out.println(s);
		if (s == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(s, HttpStatus.OK);
		}
	}

	// delete students by id
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE) // parameterize the path
	public ResponseEntity<List<Students>> deleteStudentById(@PathVariable int id) {
		Students s = this.studentService.getById(id);
		System.out.println(s);
		if (s == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} else {
			this.studentService.deleteById(id);
			return new ResponseEntity<List<Students>>(this.studentService.getAll(), HttpStatus.OK);
		}
	}

	// update student by id
	@RequestMapping(value = "/update", method = RequestMethod.PUT) // parameterize the path
	public ResponseEntity<Students> updateStudentById(@RequestParam("id") int id , @RequestParam("name") String name) {
		Students s = this.studentService.getById(id);
		if (s == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} else {
			s.setName(name);
			return new ResponseEntity<>(s, HttpStatus.OK);
		}
	}

	// create new students 
	@RequestMapping(value = "/create", method = RequestMethod.PUT) // parameterize the path
	public ResponseEntity<Students> createStudent(@RequestParam("id") int id , @RequestParam("name") String name) {
		Students s = new Students(id,name , null);
		return new ResponseEntity<>(this.studentService.createStudent(s), HttpStatus.OK);
	}
}