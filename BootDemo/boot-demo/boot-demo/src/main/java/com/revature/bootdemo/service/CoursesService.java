package com.revature.bootdemo.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.bootdemo.model.Courses;
import com.revature.bootdemo.repository.CoursesRepository;

@Service
public class CoursesService 
{
	private CoursesRepository courseRepository;

	@Autowired
	public CoursesService (CoursesRepository courseRepository) {
		this.courseRepository = courseRepository;
	}

	public Courses getById(int id){
		return this.courseRepository.getById(id);
	}

	public void deleteById(int id){
		this.courseRepository.deleteById(id);;
	}

	public List<Courses> getAll(){
		return this.courseRepository.findAll();
	}

	public Courses createCourse(Courses s){
		return this.courseRepository.save(s);
	}

}