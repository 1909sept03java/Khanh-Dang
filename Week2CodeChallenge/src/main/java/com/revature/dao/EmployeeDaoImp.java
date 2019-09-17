package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.EmployeeBeans;
import com.revature.util.ConnectionUtil;

public class EmployeeDaoImp implements EmployeeDao
{

	@Override
	public List<EmployeeBeans> getEmployee() {
		List<EmployeeBeans> bean = new ArrayList<>();
		// try-with-resources... resources included in the try args will be closed at the end of the block
		// works with all AutoCloseable resources
		try (Connection conn = ConnectionUtil.getConnection("connection.properties")) 
		{
			String sql = "SELECT * FROM EMPLOYEE";
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while(resultSet.next()) 
			{	
				int EMPLOYEE_ID = resultSet.getInt("EMPLOYEE_ID");
				String EMP_FIRSTNAME = resultSet.getString("EMP_FIRSTNAME");
				String EMP_EMAIL = resultSet.getString("EMP_EMAIL");
				String EMP_LASTNAME = resultSet.getString("EMP_LASTNAME");
				int DEPARTMENT_ID = resultSet.getInt("DEPARTMENT_ID");
				double salary = resultSet.getInt("SALARY");
				bean.add(new EmployeeBeans(EMPLOYEE_ID, EMP_FIRSTNAME, EMP_EMAIL,EMP_LASTNAME,DEPARTMENT_ID,salary));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return bean;
	}

	@Override
	public EmployeeBeans getEmployeeById(int id) 
	{
		EmployeeBeans c = null;
		// try-with-resources... resources included in the try args will be closed at the end of the block
		// works with all AutoCloseable resources
		try (Connection conn = ConnectionUtil.getConnection("connection.properties")) 
		{
			String sql = "SELECT * FROM EMPLOYEE WHERE EMPLOYEE_ID = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int EMPLOYEE_ID = rs.getInt("EMPLOYEE_ID");
				String EMP_FIRSTNAME = rs.getString("EMP_FIRSTNAME");
				String EMP_EMAIL = rs.getString("EMP_EMAIL");
				String EMP_LASTNAME = rs.getString("EMP_LASTNAME");
				int DEPARTMENT_ID = rs.getInt("DEPARTMENT_ID");
				double salary = rs.getInt("SALARY");
				c = new EmployeeBeans(EMPLOYEE_ID, EMP_FIRSTNAME, EMP_EMAIL,EMP_LASTNAME,DEPARTMENT_ID,salary);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return c;
	}

	@Override
	public void createEmployee(EmployeeBeans employee) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateEmployee(EmployeeBeans employee) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteEmployee(EmployeeBeans employee) {
		// TODO Auto-generated method stub

	}
}