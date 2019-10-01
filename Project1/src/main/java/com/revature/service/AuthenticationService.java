package com.revature.service;

import java.util.List;

import com.revature.beans.CredentialsBeans;
import com.revature.beans.EmployeeBeans;
import com.revature.beans.UsersBeans;
import com.revature.dao.EmployeeDaoImp;

public class AuthenticationService 
{
	public EmployeeBeans authenticateUser(CredentialsBeans creds) {
		// if the credentials are not recognized, return null
		// if they are, return user associated with creds
		EmployeeBeans emp = new EmployeeBeans();
		EmployeeDaoImp empDAO = new EmployeeDaoImp();
		List<EmployeeBeans> empList = empDAO.getEmployees();
		for (int i = 0; i < empList.size(); i++) {
			// System.out.println(empList.get(i).getEmployeeUsername());
			if (empList.get(i).getEmployeeUsername().equals(creds.getUsername()) && empList.get(i).getEmployeePassword().equals(creds.getPassword())) {
				emp.setEmployeeId(empList.get(i).getEmployeeId());
				emp.setEmployeeUsername(empList.get(i).getEmployeeUsername());
				emp.setEmployeePassword(empList.get(i).getEmployeePassword());
				emp.setEmployeeEmail(empList.get(i).getEmployeeEmail());
				emp.setEmployeeManagerId(empList.get(i).getEmployeeManagerId());
				return emp;
			}
		}
		return null;
	}
}