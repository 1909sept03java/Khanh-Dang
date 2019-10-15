package com.revature.bootdemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.bootdemo.model.Students;

@Repository
public interface StudentsRepository extends JpaRepository<Students, Integer> {
	public Students getById(int id);
}