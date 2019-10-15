package com.revature.bootdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.bootdemo.model.Students;
import com.revature.bootdemo.repository.StudentsRepository;

@Service
public class StudentsService 
{
	private StudentsRepository studentRepository;
	
	@Autowired
	public StudentsService(StudentsRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
	
	public Students getById(int id){
		return this.studentRepository.getById(id);
	}
	
	public void deleteById(int id){
		this.studentRepository.deleteById(id);;
	}
	
	public List<Students> getAll(){
		return this.studentRepository.findAll();
	}
	
	public Students createStudent(Students s){
		return this.studentRepository.save(s);
	}

}
