package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.EmployeeBeans;
import com.revature.service.ConnectionService;

public class EmployeeDaoImp implements EmployeeDao 
{
	@Override
	public List<EmployeeBeans> getEmployees() {
		List<EmployeeBeans> empList = new ArrayList<EmployeeBeans>();
		try (Connection con = ConnectionService.getConnection();) {
			String sql = "SELECT * FROM EMP";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int employeeId = rs.getInt("EMP_ID");
				String employeeEmail = rs.getString("EMP_EMAIL");
				String employeeUsername = rs.getString("EMP_USERNAME");
				String employeePassword = rs.getString("EMP_PASSWORD");
				int employeeManagerId = rs.getInt("EMP_MANAGER_ID");
				empList.add(new EmployeeBeans(employeeId, employeeUsername, employeePassword, employeeEmail, employeeManagerId));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return empList;
	}

	@Override
	public EmployeeBeans getEmployeesById(int employeeId) {
		EmployeeBeans emp = new EmployeeBeans();
		try (Connection con = ConnectionService.getConnection();) {
			String sql = "SELECT * FROM EMP WHERE EMP_ID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, employeeId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String employeeEmail = rs.getString("EMP_EMAIL");
				String employeeUsername = rs.getString("EMP_USERNAME");
				String employeePassword = rs.getString("EMP_PASSWORD");
				int employeeManagerId = rs.getInt("EMP_MANAGER_ID");
				emp.setEmployeeId(employeeId);
				emp.setEmployeeEmail(employeeEmail);
				emp.setEmployeeUsername(employeeUsername);
				emp.setEmployeePassword(employeePassword);
				emp.setEmployeeManagerId(employeeManagerId);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return emp;
	}

}