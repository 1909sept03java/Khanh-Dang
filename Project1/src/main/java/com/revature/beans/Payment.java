package com.revature.beans;

public class Payment 
{
	int payId;
	double payAmount;
	String payStatus; 
	int empId;
	
	public Payment() {
		super();
	}
	public Payment(int reimbursementId, double reimbursementBalance, String reimbursementStatus, int employeeId) {
		super();
		this.payId = reimbursementId;
		this.payAmount = reimbursementBalance;
		this.payStatus = reimbursementStatus;
		this.empId = employeeId;
	}
	@Override
	public String toString() {
		return "Reimbursements [reimbursementId=" + payId + ", reimbursementBalance=" + payAmount
				+ ", reimbursementStatus=" + payStatus + ", employeeId=" + empId + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + empId;
		long temp;
		temp = Double.doubleToLongBits(payAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + payId;
		result = prime * result + ((payStatus == null) ? 0 : payStatus.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Payment other = (Payment) obj;
		if (empId != other.empId)
			return false;
		if (Double.doubleToLongBits(payAmount) != Double.doubleToLongBits(other.payAmount))
			return false;
		if (payId != other.payId)
			return false;
		if (payStatus == null) {
			if (other.payStatus != null)
				return false;
		} else if (!payStatus.equals(other.payStatus))
			return false;
		return true;
	}
	public int getReimbursementId() {
		return payId;
	}
	public void setReimbursementId(int reimbursementId) {
		this.payId = reimbursementId;
	}
	public double getReimbursementBalance() {
		return payAmount;
	}
	public void setReimbursementBalance(double reimbursementBalance) {
		this.payAmount = reimbursementBalance;
	}
	public String getReimbursementStatus() {
		return payStatus;
	}
	public void setReimbursementStatus(String reimbursementStatus) {
		this.payStatus = reimbursementStatus;
	}
	public int getEmployeeId() {
		return empId;
	}
	public void setEmployeeId(int employeeId) {
		this.empId = employeeId;
	}
	
}