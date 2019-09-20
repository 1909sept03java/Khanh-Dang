package com.revature.dao;

import com.revature.beans.AdminBeans;
import com.revature.beans.BankUserBeans;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class Admin implements AdminDao
{ 
	static final Logger logger = Logger.getLogger(Admin.class);
	public static final Scanner sc = new Scanner(System.in);
	//private Admin sudoisActive1 = null;
	
	public void getSudoInfo() 
	{
		Admin bankSudo = new Admin();
		logger.info("Please enter your superuser name: ");
		String name = sc.nextLine();
		AdminBeans sudo = bankSudo.getSuperuser(name);

		if (sudo == null) {
			logger.info("Invalid username! Please try again.");
			return;
		}

		logger.info("\n");
		logger.info("Welcome to Revature Bank App" + sudo.getSuperuser() + ", Please enter your super password: ");
		String pw = sc.nextLine();

		if (sudo.getSudoPassword().equals(pw)) {
			// if the input matches the password of the user, change userIsActive from NULL to the pw
			return;
		} else {
			logger.info("Invalid password!");
		}
	}

	public boolean checkIfSudoAccountExists(String superuser, String superpassword) 
	{
		try {
			// boolean sudoExists = false;
			String filename = "src/main/resources/connection.properties";
			Properties prop = new Properties();
			InputStream in = new FileInputStream(filename);
			prop.load(in);
			if (superuser.equals(prop.getProperty("superuser"))
					&& superpassword.equals(prop.getProperty("superpassword")))
				return true;

		} catch (IOException e) {
		}
		return false;
	}
	
	@Override
	public int createUser(AdminBeans sudo)
	{
		return 0;
	}

	@Override
	public AdminBeans getSudoInfo(String superuser, String superpassword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateUser(AdminBeans sudo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteUser(AdminBeans sudo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public AdminBeans getSuperuser(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AdminBeans getSudoPassword(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
