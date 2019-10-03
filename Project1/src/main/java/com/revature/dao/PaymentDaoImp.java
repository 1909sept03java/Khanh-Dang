package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Payment;
import com.revature.service.ConnectionService;

public class PaymentDaoImp implements PaymentDao 
{ 
	@Override
	public List<Payment> getReimbursements(int employeeId) {
		List<Payment> payList = new ArrayList<Payment>();
		try (Connection con = ConnectionService.getConnection();) {
			String sql = "SELECT * FROM PAYMENT";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int reimbursementId = rs.getInt("PAY_ID");
				double reimbursementBalance = rs.getDouble("PAY_AMOUNT");
				String reimbursementStatus = rs.getString("PAY_STATUS"); 
				int employeeId2 = rs.getInt("EMP_ID");
				payList.add(
						new Payment(reimbursementId, reimbursementBalance, reimbursementStatus, employeeId2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return payList;
	}

	@Override
	public List<Payment> getReimbursementsByEmployeeId(int employeeId) {
		List<Payment> payList = new ArrayList<Payment>();
		try (Connection con = ConnectionService.getConnection();) {
			String sql = "SELECT * FROM PAYMENT WHERE EMP_ID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, employeeId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int reimbursementId = rs.getInt("PAY_ID");
				double reimbursementBalance = rs.getDouble("PAY_AMOUNT");
				String reimbursementStatus = rs.getString("PAY_STATUS"); 
				payList.add(
						new Payment(reimbursementId, reimbursementBalance, reimbursementStatus, employeeId));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return payList;
	}
	
	//CREATE REIMBURSEMENT STATUS HERE 
	@Override
	public void createReimbursements(double reimbursementBalance, int employeeId) {

		try (Connection con = ConnectionService.getConnection();) {
			String sql = "INSERT INTO PAYMENT(PAY_ID, PAY_AMOUNT, PAY_STATUS, EMP_ID) VALUES(SQ_PAYMENTS_PK.NEXTVAL, ?, 'P', ?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, employeeId);
			ps.setDouble(2, reimbursementBalance);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// UPDATE REIMBURSEMENT STATUS HERE 
	@Override
	public void updateReimbursements(int reimbursementId, String reimbursementStatus) {

		try (Connection con = ConnectionService.getConnection();) {
			String sql = "UPDATE PAYMENT SET PAY_STATUS = ? WHERE PAY_ID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, reimbursementStatus);
			ps.setInt(2, reimbursementId);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteReimbursements() {
		// TODO Auto-generated method stub

	}

}