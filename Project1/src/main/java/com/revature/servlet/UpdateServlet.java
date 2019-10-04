package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImp;

@WebServlet("/updateuser")
public class UpdateServlet extends HttpServlet 
{
	private static final long serialVersionUID = 5541951590419341934L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);

	}

	// update users info here and then populate to emp web page. 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		EmployeeDao emp = new EmployeeDaoImp();
		System.out.println(req.getParameter("username"));
		System.out.println(req.getParameter("password"));
		emp.updateEmployees(Integer.parseInt(session.getAttribute("employeeId").toString()),
				req.getParameter("username"), req.getParameter("password"));
		resp.sendRedirect("logout");
	}

}
