package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ProfileServlet extends HttpServlet
{
	private static final long serialVersionUID = 8343002811379165553L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if (session != null && session.getAttribute("employeeManagerId").equals(0)) {
			System.out.println("MANAGER LOGIN");
			req.getRequestDispatcher("Manager.html").forward(req, resp);
		} else if (session != null && !session.getAttribute("employeeManagerId").equals(0)) {
			System.out.println("EMPLOYEE LOGIN");
			req.getRequestDispatcher("Profile.html").forward(req, resp);
		} else {
			resp.sendRedirect("login");
		}
	}// MANAGERS ARE 0'S, USERS ARE 1'S

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
