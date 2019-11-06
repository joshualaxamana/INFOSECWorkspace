package machine.problem.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

import machine.problem.model.InvestorBean;

@WebServlet("/listallrecords.action")
public class ListAllRecordsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ResultSet records = new InvestorBean().getAllRecords();
		
		//perform data binding on request
		request.setAttribute("record", records);
		
		//select the JSP for view
		request.getRequestDispatcher("viewallrecords.jsp")
			.forward(request, response);
	}
}
