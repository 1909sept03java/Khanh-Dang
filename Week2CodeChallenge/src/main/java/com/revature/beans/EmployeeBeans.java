package com.revature.beans;

public class EmployeeBeans
{	
	public EmployeeBeans() 
	{
		super();
	}
	public EmployeeBeans(int EMPLOYEE_ID, String EMP_FIRSTNAME, String EMP_EMAIL,String EMP_LASTNAME,int DEPARTMENT_ID, double SALARY) 
	{
		super();
		this.id = EMPLOYEE_ID;
		this.setDeptid(DEPARTMENT_ID);
		this.firstname = EMP_FIRSTNAME;
		this.setLastName(EMP_LASTNAME);
		this.salary = SALARY;
		this.setEmail(EMP_EMAIL);
	}

	private int id;
	private int deptid;
	private String firstname;
	private String email;
	private String lastname;
	private double salary;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return firstname;
	}
	public void setName(String name) {
		this.firstname = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getDeptid() {
		return deptid;
	}
	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLastName() {
		return lastname;
	}
	public void setLastName(String lname) {
		this.lastname = lname;
	}

	@Override
	public String toString()
	{
		return "Employee emp_id=" + id + ", name=" + firstname + " " + lastname + ", salary=$" + salary ;
	}

	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeBeans other = (EmployeeBeans) obj;
		if (id != other.id)
			return false;
		if (salary != other.salary)
			return false;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		return true;
	}

	@Override
	public int hashCode() 
	{
		final double prime = 31;
		double result = 1;
		result = prime * result + id;
		result = prime * result + salary;
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		return (int) result;
	}

}
