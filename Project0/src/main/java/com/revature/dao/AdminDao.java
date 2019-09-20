package com.revature.dao;

import com.revature.beans.AdminBeans;
//import com.revature.beans.BankUserBeans;


public interface AdminDao 
{
	public AdminBeans getSudoInfo(String superuser, String superpassword);
	public int createUser(AdminBeans sudo);
	public int updateUser(AdminBeans sudo);
	public int deleteUser(AdminBeans sudo);
	//public int viewUser()
	public AdminBeans getSuperuser(String name);
	public AdminBeans getSudoPassword(String name);
	

	// delete bank
		// View transaction history 
}
