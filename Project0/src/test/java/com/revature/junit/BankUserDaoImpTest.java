package com.revature.junit;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.revature.beans.BankBeans;
import com.revature.beans.BankUserBeans;
import com.revature.dao.BankUserDao;
import com.revature.dao.BankUserDaoImp;
import com.revature.main.BankAppConsole;

public class BankUserDaoImpTest {

	
	// have a BankAppConsole instance available to my JunitTest
			private static BankAppConsole bankConsole;
			
			/*
			 * Unit testing: testing most granular code possible - line and branch coverage of methods 
			 * 
			 * TDD: style of development in which the tests are written before the code
			 * red-green refactoring: start with requirement, write test, build code to match
			 * 
			 */
			
			// if any exception is thrown, test will fail
			@Rule
			public ExpectedException thrown = ExpectedException.none();
			
			@BeforeClass
			public static void initializeBankConsole() {
				bankConsole = new BankAppConsole();
			}
			
	@Test
	public void testGetUserById() 
	{
		//fail("Not yet implemented");
	}

	@Test
	public void testGetUserByName() {
		BankUserDao a = new BankUserDaoImp();
		BankUserBeans c = a.getUserByName("kdang123");
		boolean b = false;
		if(c.getUsername().equals("kdang123"));
			b = true;
		assertTrue(b);
		//fail("Not yet implemented");
	}

}
