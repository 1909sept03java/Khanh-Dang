package com.revature.util;

import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import com.revature.main.BankAppConsole;


public class Validation 
{	
	private static Scanner sc = new Scanner(System.in);
	private static final Logger logger = Logger.getLogger(BankAppConsole.class);

	public static String getValidUsername() {
		logger.info("Please enter a username: ");
		String username = sc.nextLine();

		while(!userNameIsValid(username)) {
			logger.info("Please enter a username");
			username = sc.nextLine();
		}

		return username;
	}
	
	//only accept lower case username -> custom rule
	public static boolean userNameIsValid(String username) {
		String regex = "^[a-z0-9_-]{5,15}$";
		Pattern pattern = Pattern.compile(regex);
		boolean matcher = pattern.matcher(username).matches();

		return matcher;
	}

	public static String getValidEmailAddress() {
		logger.info("Please enter a valid email address: ");
		String emailAddress = sc.nextLine();

		while(!emailAddressIsValid(emailAddress)) {
			logger.info("Please enter a valid email address: ");
			emailAddress = sc.nextLine();
		}

		return emailAddress;
	}

	public static boolean emailAddressIsValid(String email) {
		String regex = "^[a-zA-Z0-9_+"
				+ "&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +
				"(?:[a-zA-Z0-9-]+\\.)+[a-z" +
				"A-Z]{2,7}$";
		Pattern pattern = Pattern.compile(regex);
		boolean matcher = pattern.matcher(email).matches();

		return matcher;
	}

	public static String getValidPassword() {
		logger.info("Please enter a valid password. It must be at least 6 characters long with at least one special character: ");
		String password = sc.nextLine();
		
		while(!passwordIsValid(password)) {
			logger.info("Please enter a valid password. It must be at least 6 characters long with at least one special character: ");
			password = sc.nextLine();
		}

		return password;
	}
	
	//accepts minimum of 6 characters of any kind with at least one special char.
	public static boolean passwordIsValid(String password) {
		String passwordValidationRegEx = "^(?:(?=.*\\d)(?=.*[A-Z])"
				+ "(?=.*[a-z])|(?=.*\\d)(?=.*[^A-Za-z0-9])"
				+ "(?=.*[a-z])|(?=.*[^A-Za-z0-9])(?=.*[A-Z])"
				+ "(?=.*[a-z])|(?=.*\\d)(?=.*[A-Z])(?=.*[^A-Za-z0-9]))"
				+ "(?!.*(.)\\1{2,})[A-Za-z0-9!~<>,;:_=?*+#.\"&§%°()"
				+ "\\|\\[\\]\\-\\$\\^\\@\\/]{8,32}$";

		Pattern regExPattern = Pattern.compile(passwordValidationRegEx);

		if (password == null) {
			return false;
		}

		return regExPattern.matcher(password).matches();
	}

	public static boolean determineFloatPrecision(float cash) {
		Pattern p = Pattern.compile("^\\d+\\.\\d{0,2}$"); 
		Matcher matcher = p.matcher(String.valueOf(cash));  
		return matcher.matches();
	}

	public static String floatConfig(float floatVal) {
		DecimalFormat formattedDecimal = new DecimalFormat("#.00");
		return formattedDecimal.format(floatVal);
	}
}
