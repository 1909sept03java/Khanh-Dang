package com.revature.bootdemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.bootdemo.model.Courses;

@Repository
public interface CoursesRepository extends JpaRepository<Courses, Integer> {
	public Courses getById(int id);
}