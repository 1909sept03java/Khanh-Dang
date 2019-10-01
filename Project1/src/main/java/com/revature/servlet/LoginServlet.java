package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.CredentialsBeans;
import com.revature.beans.EmployeeBeans;
import com.revature.beans.UsersBeans;
import com.revature.service.AuthenticationService;

public class LoginServlet extends HttpServlet
{
	private AuthenticationService authService = new AuthenticationService();
	private static final long serialVersionUID = 817105812389880890L;
	
	/*
	 * Create two methods: - a doGet to handle GET requests for our login page - a
	 * doPost to handle POST requests with credentials
	 */

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// serve the login.html page as a response
		// RequestDispatcher is used to perform a 'forward'
		// (pass the request to another resource without the client knowing)
		req.getRequestDispatcher("Login.html").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		CredentialsBeans creds = new CredentialsBeans();
		creds.setUsername(req.getParameter("username"));
		creds.setPassword(req.getParameter("password"));
		// passing the responsibility for performing auth logic to a service
		EmployeeBeans emp = authService.authenticateUser(creds);
		if (emp != null) {
			// check if user is real
			System.out.println("Employee exists");
			System.out.println(emp.toString());
			session.setAttribute("employeeId", emp.getEmployeeId());
			session.setAttribute("employeeUsername", emp.getEmployeeUsername());
			session.setAttribute("employeePassword", emp.getEmployeePassword());
			session.setAttribute("employeeEmail", emp.getEmployeeEmail());
			session.setAttribute("employeeManagerId", emp.getEmployeeManagerId());
			resp.sendRedirect("profile");
		} else { // user is not real, redirect back 
			
			session.setAttribute("problem", "Invalid Credentials");
			System.out.println("User Does Not Exists in Database");
			resp.sendRedirect("login");
		}
	}
}
