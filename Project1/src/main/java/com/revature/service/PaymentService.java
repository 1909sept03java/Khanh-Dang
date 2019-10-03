package com.revature.service;

import java.util.List;

import com.revature.beans.Payment;
import com.revature.dao.PaymentDaoImp;

public class PaymentService 
{
	private PaymentDaoImp payImp = new PaymentDaoImp();
	
	public List<Payment> getReimbursements(int employeeId)
	{
		return payImp.getReimbursements(employeeId);
	}
	
	public void createReimbursements(double reimbursementBalance, int employeeId)
	{
		 payImp.createReimbursements(reimbursementBalance, employeeId);
	}

}
