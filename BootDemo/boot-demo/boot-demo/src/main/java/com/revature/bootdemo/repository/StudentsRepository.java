package com.revature.bootdemo.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.revature.bootdemo.model.Students;

@RepositoryRestResource(collectionResourceRel = "students", path = "students")
public interface StudentsRepository extends PagingAndSortingRepository<Students, Long> {

	List<Students> findByLastName(@Param("name") String name);

}