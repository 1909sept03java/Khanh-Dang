package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.DepartmentBeans;
import com.revature.util.ConnectionUtil;

public class DepartmentDaoImp implements DepartmentDao
{

	@Override
	public List<DepartmentBeans> getDepartment() {
		List<DepartmentBeans> bean = new ArrayList<>();
		// try-with-resources... resources included in the try args will be closed at the end of the block
		// works with all AutoCloseable resources
		try (Connection conn = ConnectionUtil.getConnection("connection.properties")) 
		{
			String sql = "SELECT * FROM DEPARTMENT";
			Statement stmt = conn.createStatement();
			ResultSet resultSet = stmt.executeQuery(sql);
			while(resultSet.next()) {

				int DEPARTMENT_ID = resultSet.getInt("DEPARTMENT_ID");

				String DEPARTMENT_NAME = resultSet.getString("DEPARTMENT_NAME");

				bean.add(new DepartmentBeans(DEPARTMENT_ID, DEPARTMENT_NAME));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return bean;
	}

	@Override
	public DepartmentBeans getDepartmentById(int id) {
		DepartmentBeans c = null;
		// try-with-resources... resources included in the try args will be closed at the end of the block
		// works with all AutoCloseable resources
		try (Connection conn = ConnectionUtil.getConnection("connection.properties")) {
			String sql = "SELECT * FROM DEPARTMENT WHERE DEPARTMENT_ID = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet resultSet = pstmt.executeQuery();
			while(resultSet.next()) {

				int DEPARTMENT_ID = resultSet.getInt("DEPARTMENT_ID");
				String DEPARTMENT_NAME = resultSet.getString("DEPARTMENT_NAME");
				c = new DepartmentBeans(DEPARTMENT_ID, DEPARTMENT_NAME);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return c;
	}

	@Override
	public void createDepartment(DepartmentBeans department) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateDepartment(DepartmentBeans department) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteDepartment(DepartmentBeans department) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteEmployee(DepartmentBeans department) {
		// TODO Auto-generated method stub

	}
}