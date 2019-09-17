package com.revature.dao;

import java.util.List;
import java.io.IOException;

import com.revature.beans.EmployeeBeans;

public interface EmployeeDao 
{
	public List<EmployeeBeans> getEmployee() throws IOException;
	public EmployeeBeans getEmployeeById(int id) throws IOException;
	public void createEmployee(EmployeeBeans employee);
	public void updateEmployee(EmployeeBeans employee);
	public void deleteEmployee(EmployeeBeans employee);

}