package com.revature.dao;

import java.util.List;

import com.revature.beans.BankBeans;

public interface BankDao 
{	
	public List<BankBeans> getAllBanks();
	public BankBeans getBankById(int id);
	public int createBank(BankBeans bank);
	public int updateBank(BankBeans bank);
	public BankBeans getBankByUserId(int id);
	public boolean deposit(int id, float balance);
	public void withdraw(int id);
	public void deposit(int id);
	
}