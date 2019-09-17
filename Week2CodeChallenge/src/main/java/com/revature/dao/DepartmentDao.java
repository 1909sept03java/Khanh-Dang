package com.revature.dao;

import java.io.IOException;
import java.util.List;

import com.revature.beans.DepartmentBeans;

public interface DepartmentDao 
{
	public List<DepartmentBeans> getDepartment() throws IOException;
	public DepartmentBeans getDepartmentById(int id) throws IOException;
	public void createDepartment(DepartmentBeans department);
	public void updateDepartment(DepartmentBeans department);
	public void deleteEmployee(DepartmentBeans department);
	void deleteDepartment(DepartmentBeans department);

}
