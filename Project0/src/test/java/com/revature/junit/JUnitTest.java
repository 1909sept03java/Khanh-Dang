package com.revature.junit;

import junit.framework.Test;

import junit.framework.TestSuite;
import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Rule;

import org.junit.rules.ExpectedException;

import com.revature.main.BankAppConsole;
public class JUnitTest
{
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
		
		//TESTS
		
		//@Test
		public void emptyStringReturnsZero() throws BankAppException {
			//assertEquals(0, bankConsole.add(""), .0001);
		}
		
		//@Test
		public void nullReturnsZero() throws BankAppException {
			//assertEquals(0, bankConsole.add(null), .0001);
		}
		
		//@Test
		public void moreThanTwoThrowsException() throws BankAppException {
			thrown.expect(BankAppException.class);
			//bankConsole.add("4,5,6");
		}
		
		//@Test
		public void incorrectCharactersThrowsException() throws BankAppException {
			thrown.expect(BankAppException.class);
			//bankConsole.add("4,cat");
		}
		
}
