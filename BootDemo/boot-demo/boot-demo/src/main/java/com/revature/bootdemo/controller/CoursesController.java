package com.revature.bootdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.bootdemo.model.Courses;
import com.revature.bootdemo.service.CoursesService;

@RestController // @RestController = @Controller + @ResponseBody
@RequestMapping(value = "/course")
public class CoursesController {
	private CoursesService courseService;

	@Autowired
	public CoursesController(CoursesService courseService) {
		this.courseService = courseService;
	}
	
	// get all courses
	@RequestMapping(value = "/all", method = RequestMethod.GET) // parameterize the path
	public ResponseEntity<List<Courses>> getAll() {
		return new ResponseEntity<>(this.courseService.getAll(), HttpStatus.OK);
	}
	
	// get courses id
	@RequestMapping(value = "/{id}", method = RequestMethod.GET) // parameterize the path
	public ResponseEntity<Courses> getCourseId(@PathVariable int id) {
		Courses s = this.courseService.getById(id);
		System.out.println(s);
		if (s == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(s, HttpStatus.OK);
		}
	}
	
	// delete student by id
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE) // parameterize the path
	public ResponseEntity<List<Courses>> deleteStudentById(@PathVariable int id) {
		Courses s = this.courseService.getById(id);
		System.out.println(s);
		if (s == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} else {
			this.courseService.deleteById(id);
			return new ResponseEntity<List<Courses>>(this.courseService.getAll(), HttpStatus.OK);
		}
	}
	
	// update student by id
	@RequestMapping(value = "/update", method = RequestMethod.PUT) // parameterize the path
	public ResponseEntity<Courses> updateStudentById(@RequestParam("id") int id , @RequestParam("name") String name) {
		Courses s = this.courseService.getById(id);
		if (s == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} else {
			s.setDescription(name);
			return new ResponseEntity<>(s, HttpStatus.OK);
		}
	}
	
	// create course
	@RequestMapping(value = "/create", method = RequestMethod.PUT) // parameterize the path
	public ResponseEntity<Courses> createCourse(@RequestParam("id") int id , @RequestParam("name") String name) {
		Courses s = new Courses(id,name);
		return new ResponseEntity<>(this.courseService.createCourse(s), HttpStatus.OK);
	}

}