package com.revature.main;

import java.util.Scanner;
import org.apache.log4j.Logger;

import com.revature.beans.AdminBeans;
import com.revature.beans.BankBeans;
import com.revature.beans.BankUserBeans;
//import com.revature.dao.Admin;
import com.revature.dao.BankDaoImp;
import com.revature.dao.BankUserDaoImp;
import com.revature.util.Validation;

public class BankAppConsole //extends Admin 
{
	// log4j it is possible to enable logging at runtime without modifying the application binary.
	/* debug : developer - manual debugging
	trace : automated logging and step tracer - for 3rd level support
	info : technician / support level 1 /2
	warn : technician / user error : automated alert / support level 1
	critical/fatal : depends on your setup - local IT*/
	
	static final Logger logger = Logger.getLogger(BankAppConsole.class);

	private static BankAppConsole singleton = null;
	protected BankUserBeans userIsActive = null;
	//protected AdminBeans sudoIsActive = null;

	public static final Scanner sc = new Scanner(System.in);

	public BankAppConsole() {
		super();
	}

	// set null variables for Singleton Design Pattern function for storing data and maintaining session state with a singleton class
	// managing access to a resource which is shared by the entire application into one thread, 
	//and it would be destructive to potentially have multiple instances of the same class.
	public static BankAppConsole setSingleton() {
		if (singleton == null) {
			singleton = new BankAppConsole();
		}

		return singleton;
	}

	private void introMenu()
	{// while loop suggested for going back function
		BankUserDaoImp bankUser = new BankUserDaoImp();
		//Admin admin = new Admin();
		if(userIsActive == null) 
		{	
			logger.info("1. Create an account");
			logger.info("2. Sign In");
			logger.info("3. Sudo Sign In");
			logger.info("Enter q to quit");
		}// for super user option

		else if (bankUser.checkIfAccountExists(userIsActive.getUsername())) 
		{
			logger.info("1. New Account Registration");
			logger.info("2. Deposit");
			logger.info("3. Withdraw");
			logger.info("4. Check balance");
			logger.info("Press q to quit");
		}//sudo ui
		
		/*
		else if (admin.checkIfSudoAccountExists(sudoIsActive.getSuperuser(), sudoIsActive.getSudoPassword()))
		{//view, create, update, delete all users
			logger.info("1. View");
			logger.info("2. Create");
			logger.info("3. Update");
			logger.info("4. Delete");
			logger.info("Press q to quit");
		}*/
		
		else 
		{
			logger.info("1. Create a new bank account");
			logger.info("2. Logout");
			logger.info("Press q to quit");
		}
		
		logger.info("");
		
	}
	/*
	private void adminMenu()
	{
		Admin admin = new Admin();
		for 
		admin.checkIfSudoAccountExists(sudoIsActive.getSuperuser(), sudoIsActive.getSudoPassword();
		logger.info("1. View");
		logger.info("2. Create");
		logger.info("3. Update");
		logger.info("4. Delete");
		logger.info("Press q to quit");
		
	}*/
	
	public void start() 
	{
		logger.info("WELCOME TO REVATURE BANK APP!");
		introMenu();
		//if(userIsActive == null) 
			//adminMenu();
		String userInput = "";

		while(userInput != "q") {

			userInput = sc.nextLine().toLowerCase();
			actOnInput(userInput);
			introMenu();

		}

	}

	// registers account
	public void createAccount() {
		BankUserDaoImp buImp = new BankUserDaoImp();
		BankUserBeans newUser = new BankUserBeans();
		String username = Validation.getValidUsername();
		newUser.setUsername(username);

		if (!buImp.isUsernameUnique(newUser)) {
			logger.info("Username already exists. Please try a different username.");
			return;
		}

		String email = Validation.getValidEmailAddress();
		newUser.setEmail(email);

		if (!buImp.isUserEmailUnique(newUser)) {
			logger.info("Email already exists in our database. Please try a different one.");
			return;
		}

		String password = Validation.getValidPassword();
		newUser.setUserPassword(password);

		buImp.createUser(newUser);
	}

	// creates the financial aspect of the user account
	public void createBank() {

		if (userIsActive == null)  {
			logger.info("Access denied.");
			return;
		}

		BankUserDaoImp usersDaoImpl =  new BankUserDaoImp();
		BankDaoImp bankImpl = new BankDaoImp();
		bankImpl.createBank(usersDaoImpl.getUserIdByUsername(userIsActive.getUsername()));

	}

	public void loggedOutOptions(String menuChoice) 
	{
		switch(menuChoice) {
		case "1":
			createAccount();
			break;
			// add other cases after methods are established
		case "2":
			signIn();
			break;
		/*case"3":
			//getSudoInfo();
			break;*/
		case "q":
			end();
			System.exit(0);
		default:
			break;
		}

	}

	public void actOnInput(String action)
	{
		if (userIsActive == null) {
			loggedOutOptions(action);
		} else {
			loggedInOptions(action);
		}
		/*if (sudoIsActive == null) 
			loggedOutOptions(action);
		else
			loggedInOptions(action);*/
			
	}

	public void loggedInOptions(String action) {
		BankUserDaoImp userImpl = new BankUserDaoImp();

		switch(action) {

		case "1":
			createBank();
			break;

		case "2":
			if (!userImpl.checkIfAccountExists(userIsActive.getUsername())) {
				logger.info("Account Does Not Exist!");
				break;
			}

			deposit();
			break;

		case "3":
			if(!userImpl.checkIfAccountExists(userIsActive.getUsername())) {
				logger.info("Account Does Not Exist!");
				break;
			}

			withdraw();
			break;

		case "4":
			if(!userImpl.checkIfAccountExists(userIsActive.getUsername())) {
				logger.info("Account Does Not Exist!");
				break;
			}

			checkBalance();
			break;
		case "q":
			end();
			System.exit(0);
		default:
			break;

		}
	}

	public void deposit() {
		BankDaoImp bankImpl = new BankDaoImp();
		BankBeans bank = bankImpl.getBankByUserId(userIsActive.getId());
		bankImpl.deposit(bank.getId());

	}

	public void signIn() {
		BankUserDaoImp bankUsersImpl = new BankUserDaoImp();
		logger.info("Please enter your username: ");
		String name = sc.nextLine();
		BankUserBeans user = bankUsersImpl.getUserByName(name);

		if (user == null) {
			logger.info("Invalid username! Please try again.");
			return;
		}

		logger.info("\n");
		logger.info("Welcome to Revature Bank App " + user.getUsername() + ", Please enter your password: ");
		String pw = sc.nextLine();

		if (user.getUserPassword().equals(pw)) {
			// if the input matches the password of the user, change userIsActive from NULL to the pw
			userIsActive = user;
		} else {
			logger.info("Invalid password!");
		}
	}

	public void signOut() {
		userIsActive = null;
		logger.info("You have successfully logged out.");
	}

	private void checkBalance() {
		BankDaoImp bankImpl = new BankDaoImp();
		logger.info("Your balance is: $" + Validation.floatConfig(bankImpl.viewBalanceByUserId(userIsActive.getId())));
	}

	private void withdraw() {
		BankDaoImp bankImpl = new BankDaoImp();
		BankBeans bank = bankImpl.getBankByUserId(userIsActive.getId());
		bankImpl.withdraw(bank.getId());	
	}

	private void end() {
		logger.info("Exit Revature Bank. Have a Good Day!");
		userIsActive = null;
	}

}