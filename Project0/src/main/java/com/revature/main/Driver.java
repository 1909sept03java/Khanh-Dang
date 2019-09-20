package com.revature.main;

import org.apache.log4j.Logger;

public class Driver 
{
	static final Logger logger = Logger.getLogger(Driver.class);

	public static void main(String[] args) 
	{
		BankAppConsole bankApp = BankAppConsole.setSingleton();
		bankApp.start();
	}

}