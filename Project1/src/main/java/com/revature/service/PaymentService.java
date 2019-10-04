package com.revature.service;

import java.util.List;

import com.revature.beans.EmployeeBeans;
import com.revature.beans.Payment;
import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImp;
import com.revature.dao.PaymentDaoImp;

public class PaymentService 
{
	private PaymentDaoImp payImp = new PaymentDaoImp();
	
	public List<Payment> getReimbursementsByEmployeeId(int employeeId)
	{
		return payImp.getReimbursementsByEmployeeId(employeeId);
	}
	
	public void createReimbursements(double reimbursementBalance, int employeeId)
	{
		 payImp.createReimbursements(reimbursementBalance, employeeId);
	}

	public static List<EmployeeBeans> getEmployees() {
		EmployeeDao emp = new EmployeeDaoImp();
		return emp.getEmployees(); // to work on
	}

}
