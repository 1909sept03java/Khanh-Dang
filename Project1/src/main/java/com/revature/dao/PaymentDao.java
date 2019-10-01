package com.revature.dao;

import java.util.List;

import com.revature.beans.Payment;

public interface PaymentDao
{
	public List<Payment> getReimbursements();
	public List<Payment> getReimbursementsByEmployeeId(int employeeId);
	public void createReimbursements(double reimbursementBalance, int employeeId);
	public void updateReimbursements(int reimbursementId, String reimbursementStatus);
	public void deleteReimbursements();
	
}