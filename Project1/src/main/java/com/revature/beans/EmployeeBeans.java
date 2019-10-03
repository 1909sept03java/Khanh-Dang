package com.revature.beans;

public class EmployeeBeans 
{	
	int empId;
	String employeeEmail;
	String employeeUsername;
	String employeePassword;
	int employeeManagerId;
	
	public EmployeeBeans() {
		super();
	}
	public EmployeeBeans(int employeeId, String employeeUsername, String employeePassword, String employeeEmail,
			int employeeManagerId) {
		super();
		this.empId = employeeId;
		this.employeeUsername = employeeUsername;
		this.employeePassword = employeePassword;
		this.employeeEmail = employeeEmail;
		this.employeeManagerId = employeeManagerId;
	}
	@Override
	public String toString() {
		return "Employees [employeeId=" + empId + ", employeeUsername=" + employeeUsername + ", employeePassword="
				+ employeePassword + ", employeeEmail=" + employeeEmail + ", employeeManagerId=" + employeeManagerId
				+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((employeeEmail == null) ? 0 : employeeEmail.hashCode());
		result = prime * result + empId;
		result = prime * result + employeeManagerId;
		result = prime * result + ((employeePassword == null) ? 0 : employeePassword.hashCode());
		result = prime * result + ((employeeUsername == null) ? 0 : employeeUsername.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeBeans other = (EmployeeBeans) obj;
		if (employeeEmail == null) {
			if (other.employeeEmail != null)
				return false;
		} else if (!employeeEmail.equals(other.employeeEmail))
			return false;
		if (empId != other.empId)
			return false;
		if (employeeManagerId != other.employeeManagerId)
			return false;
		if (employeePassword == null) {
			if (other.employeePassword != null)
				return false;
		} else if (!employeePassword.equals(other.employeePassword))
			return false;
		if (employeeUsername == null) {
			if (other.employeeUsername != null)
				return false;
		} else if (!employeeUsername.equals(other.employeeUsername))
			return false;
		return true;
	}
	public int getEmployeeId() {
		return empId;
	}
	public void setEmployeeId(int employeeId) {
		this.empId = employeeId;
	}
	public String getEmployeeUsername() {
		return employeeUsername;
	}
	public void setEmployeeUsername(String employeeUsername) {
		this.employeeUsername = employeeUsername;
	}
	public String getEmployeePassword() {
		return employeePassword;
	}
	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}
	public String getEmployeeEmail() {
		return employeeEmail;
	}
	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}
	public int getEmployeeManagerId() {
		return employeeManagerId;
	}
	public void setEmployeeManagerId(int employeeManagerId) {
		this.employeeManagerId = employeeManagerId;
	}
	
}