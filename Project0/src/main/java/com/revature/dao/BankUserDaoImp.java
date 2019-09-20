package com.revature.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.beans.BankUserBeans;
import com.revature.main.BankAppConsole;
import com.revature.util.ConnectionUtil;

public class BankUserDaoImp implements BankUserDao
{
	public static final Scanner sc = new Scanner(System.in);
	static final Logger logger = Logger.getLogger(BankAppConsole.class);

	public boolean checkIfAccountExists(String name)
	{
		boolean accountExists = false;
		BankUserBeans user = getUserByName(name);
		ResultSet rs = null;
		String sql = "SELECT * FROM BANK WHERE USER_ID = ?";
		try (Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);) {

			ps.setInt(1, user.getId());
			rs = ps.executeQuery();

			if (rs.isBeforeFirst()) {
				accountExists = true;
			}

		} catch (SQLException|IOException e) {
			logger.error(e.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					logger.error(e.getMessage());
				}
			}
		}
		return accountExists;

	}
	// check sudo account if it exists
	
	
	
	public int getUserIdByUsername(String username) {
		int id = 0;
		ResultSet rs = null;
		String sql = "SELECT * FROM BANK_USERS WHERE USERNAME = ?";

		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, username);
			rs = ps.executeQuery();

			while(rs.next()) {
				id = rs.getInt("USER_ID");
			}


		} catch (SQLException|IOException e) {
			logger.error(e.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					logger.error(e.getMessage());
				}
			}
		}

		return id;


	}


	@Override
	public BankUserBeans getUserById(int id) {
		return null;
	}

	@Override
	public BankUserBeans getUserByName(String name) {

		ResultSet rs = null;
		BankUserBeans user = null;
		String sql = "SELECT * FROM BANK_USERS WHERE USERNAME = ?";

		try (Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
			ps.setString(1, name);
			rs = ps.executeQuery();

			int id = 0;
			String username;
			String emailAddress;
			String password;

			while (rs.next()) {
				username = rs.getString("USERNAME");
				emailAddress = rs.getString("EMAIL");
				password = rs.getString("USER_PASSWORD");
				id = rs.getInt("USER_ID");
				user = new BankUserBeans(password, id, username, emailAddress);

			}
		} catch (SQLException|IOException e) {
			logger.error(e.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					logger.error(e.getMessage());
				}
			}
		}

		return user;
	}

	@Override
	public int createUser(BankUserBeans user) {
		int createdUsers = 0;
		String sql = "INSERT INTO BANK_USERS (USERNAME, EMAIL, USER_PASSWORD) VALUES (? ,? ,?)";

		try (Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1,  user.getUsername());
			ps.setString(2, user.getEmail());
			ps.setString(3,  user.getUserPassword());

			createdUsers = ps.executeUpdate();
		} catch (SQLException|IOException e) {
			logger.error(e.getMessage());
		}

		if (createdUsers > 0) {
			logger.info("Thanks for creating an account with us! Welcome to Revature Bank!\n");
		} else {
			logger.info("Your attempt to create an account was unsuccessful. Please try again.\n");
		}
		return createdUsers;
	}
	
	// Delete User
	
	@Override
	public int updateUser(BankUserBeans user) {
		return 0;
	}

	@Override
	public int hideUserById(BankUserBeans user) {
		return 0;
	}

	@Override
	public boolean isUsernameUnique(BankUserBeans user) {
		boolean isUnique = false;
		String username = user.getUsername();
		String sql = "SELECT * FROM BANK_USERS WHERE USERNAME = ?";
		ResultSet rs = null;

		try (Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setString(1, username);
			rs = ps.executeQuery();

			if (!rs.isBeforeFirst()) {
				isUnique = true;
			}
		} catch (SQLException|IOException e) {
			logger.error(e.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					logger.error(e.getMessage());
				}
			}
		}
		return isUnique;
	}

	@Override
	public boolean isUserEmailUnique(BankUserBeans user) {
		boolean isUnique = false;
		String emailAddress = user.getEmail();
		String sql = "SELECT * FROM BANK_USERS WHERE EMAIL = ?";
		ResultSet rs = null;

		try (Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setString(1, emailAddress);
			rs = ps.executeQuery();

			if (!rs.isBeforeFirst()) {
				isUnique = true;
			}
		} catch (SQLException|IOException e) {
			logger.error(e.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					logger.error(e.getMessage());
				}
			}
		}
		return isUnique;
	}
	/*
	@Override
	public BankUserBeans getSudoInfo(String superuser, String superpassword) 
	{
		BankUserDaoImp bankSudo = new BankUserDaoImp();
		logger.info("Please enter your username: ");
		String name = sc.nextLine();
		BankUserBeans sudo = bankSudo.getUserByName(name);

		if (sudo == null) {
			logger.info("Invalid username! Please try again.");
			return;
		}

		logger.info("\n");
		logger.info("Welcome to Revature Bank App" + sudo.getUsername() + ", Please enter your password: ");
		String pw = sc.nextLine();

		if (sudo.getUserPassword().equals(pw)) {
			// if the input matches the password of the user, change userIsActive from NULL to the pw
			userIsActive = sudo;
		} else {
			logger.info("Invalid password!");
		}
		
		//store data 
		//then check if matches 
	}*/

}
