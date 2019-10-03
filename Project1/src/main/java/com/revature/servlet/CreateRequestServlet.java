package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.PaymentDaoImp;
import com.revature.service.PaymentService;

@WebServlet("/createreqsession")
public class CreateRequestServlet extends HttpServlet
{
	private static final long serialVersionUID = -5008002028844664624L;
	
	public CreateRequestServlet()
	{
		super();
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//doPost(req, resp);
	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		System.out.println(session);
		try 
		{
			PaymentService ps = new PaymentService();
			double reimbursementBalance = Double.parseDouble(req.getParameter("reimbursementBalance").toString());
			int empId = Integer.parseInt(session.getAttribute("employeeId").toString());
			ps.createReimbursements(reimbursementBalance,empId);
			resp.sendRedirect("profile");
		}catch(Exception e)
		{
			e.printStackTrace();
			resp.getWriter().write("{\"session\":null}");
		}
	}
	
}
