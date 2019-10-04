package com.revature.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.EmployeeBeans;
import com.revature.service.PaymentService;

public class EmployeeInfoServlet extends HttpServlet { // to work on
	
	private static final long serialVersionUID = -4546675546542792032L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			List<EmployeeBeans> empList = PaymentService.getEmployees();
			resp.getWriter().write((new ObjectMapper()).writeValueAsString(empList));
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
