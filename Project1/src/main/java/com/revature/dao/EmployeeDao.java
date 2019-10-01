package com.revature.dao;

import java.util.List;

import com.revature.beans.EmployeeBeans;

public interface EmployeeDao
{	
	public List<EmployeeBeans> getEmployees();
	public EmployeeBeans getEmployeesById(int employeeId);

}