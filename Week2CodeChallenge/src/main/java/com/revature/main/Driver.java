package com.revature.main;

import java.sql.Connection;

import com.revature.dao.AverageDao;
import com.revature.dao.DepartmentDao;
import com.revature.dao.DepartmentDaoImp;
import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImp;
import com.revature.util.ConnectionUtil;

public class Driver 
{
	public static void main(String[] args)  
	{
		try 
		{
			EmployeeDao ed = new EmployeeDaoImp();
			DepartmentDao dd = new DepartmentDaoImp();

			System.out.println(ed.getEmployeeById(1));
			System.out.println(dd.getDepartmentById(1000));
			System.out.println("Department Average Salary Before Increase:");
			System.out.println("$"+ AverageDao.getAVG(1001));
			System.out.println("Department Average Salary After Increase:");
			AverageDao.SetAvg(1001);
			System.out.println("$"+ AverageDao.getAVG(1001));
		}

		catch (Exception e) 
		{

		}

	}

}
