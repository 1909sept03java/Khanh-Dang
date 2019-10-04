package com.revature.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.beans.EmployeeBeans;

public class EmployeeDaoImpTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetEmployees() {
		boolean actual = false;
		EmployeeDao empDao = new EmployeeDaoImp();
		List<EmployeeBeans> empList = new ArrayList<EmployeeBeans>();
		empList = empDao.getEmployees();
		for(EmployeeBeans e: empList)
		{
			if(e.getEmployeeUsername().equals("kd3595"))
				actual = true;
		}
		assertTrue(actual);
	}
	
	
	@Test
	public void testGetEmployeesById() {
		boolean actual = false;
		EmployeeDao employD = new EmployeeDaoImp();
		EmployeeBeans e = employD.getEmployeesById(1);
		if(e.getEmployeeUsername().equals("kd3595"))
			actual = true;
		
		assertTrue(actual);
	}

	/*
	@Test
	public void testUpdateEmployees() {
		EmployeeBeans employ = new EmployeeBeans();
		boolean actual = false;
		EmployeeDao employD = new EmployeeDaoImp();
		employD.updateEmployees(employ);
		EmployeeBeans e = employD.getEmployeesById(3);
		if(e.getEmail().equals("JHalpert@gmail.com"))
			actual = true;
		
		assertTrue(actual);
	}*/

}
