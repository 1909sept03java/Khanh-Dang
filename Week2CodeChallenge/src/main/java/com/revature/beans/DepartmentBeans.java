package com.revature.beans;

public class DepartmentBeans 
{

	public DepartmentBeans () 
	{
		super();
	}

	public DepartmentBeans (int DEPARTMENT_ID, String DEPARTMENT_NAME) 
	{
		super();

		this.setDepId(DEPARTMENT_ID);
		this.depName = DEPARTMENT_NAME;

	}

	private int depid;

	private String depName;

	public int getDepId() 
	{
		return depid;
	}

	public void setDepId(int deptid) 
	{
		this.depid = deptid;
	}

	@Override
	public String toString() {
		return "dep_id=" + depid + ", name=" + depName;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DepartmentBeans  other = (DepartmentBeans ) obj;
		if (depid != other.depid)
			return false;
		return true;

	}

}