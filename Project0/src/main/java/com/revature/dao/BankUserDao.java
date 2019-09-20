package com.revature.dao;

import com.revature.beans.BankUserBeans;

public interface BankUserDao 
{
	public BankUserBeans getUserById(int id);
	public BankUserBeans getUserByName(String name);
	public int createUser(BankUserBeans user);
	public int updateUser(BankUserBeans user);
	public int hideUserById(BankUserBeans user);
	public boolean isUsernameUnique(BankUserBeans user);
	public boolean isUserEmailUnique(BankUserBeans user);
}