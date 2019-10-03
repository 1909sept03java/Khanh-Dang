package com.revature.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.EmployeeBeans;
import com.revature.beans.Payment;
import com.revature.dao.PaymentDaoImp;
import com.revature.service.PaymentService;

@WebServlet("/requestsession")
public class RequestServlet extends HttpServlet 
{
	private static final long serialVersionUID = 8070115056439532175L;
	private PaymentService rs;
	private ObjectMapper om;
	
	public RequestServlet()
	{
		rs = new PaymentService();
		om = new ObjectMapper();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		HttpSession session = req.getSession(false);
		try 
		{
			int empId = Integer.parseInt(session.getAttribute("employeeId").toString());
			List<Payment> table = new ArrayList<Payment>();
			table = rs.getReimbursements(empId);
			resp.getWriter().write((new ObjectMapper()).writeValueAsString(table));
			
		} catch (Exception e) {
			e.printStackTrace();
			resp.getWriter().write("{\"session\":null}");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
