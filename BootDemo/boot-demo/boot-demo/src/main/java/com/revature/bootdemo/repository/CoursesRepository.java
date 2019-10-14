package com.revature.bootdemo.repository;
import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.revature.bootdemo.model.Courses;

@RepositoryRestResource(collectionResourceRel = "courses", path = "courses")
public interface CoursesRepository extends PagingAndSortingRepository<Courses, Long> {

	List<Courses> findById(@Param("id") int id);

}