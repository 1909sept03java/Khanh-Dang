package com.revature.bootdemo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
@Table(name="STUDENTS")
public class Students 
{	
	@Min(0) 
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO, generator="studentSequence")
	@SequenceGenerator(allocationSize=1, name="studentSequence", sequenceName="SQ_STUDENTS_PK")
	@Column(name="STUDENT_ID")
	private int id;
	private String name;
	@ManyToMany(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	@JoinTable(name="STUDENTS_COURSES",
	joinColumns = {@JoinColumn(name="STUDENT_ID")},
	inverseJoinColumns = {@JoinColumn(name="COURSE_ID")})
	private List<Courses> courses = new ArrayList<>();

	public Students() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public Students(@Min(0) int id, String name, List<Courses> courses) {
		super();
		this.id = id;
		this.name = name;
		this.courses = courses;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Courses> getCourses() {
		return courses;
	}

	public void setCourses(List<Courses> courses) {
		this.courses = courses;
	}
}