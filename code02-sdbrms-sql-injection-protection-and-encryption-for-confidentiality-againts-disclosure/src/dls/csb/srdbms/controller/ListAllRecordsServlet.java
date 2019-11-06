package dls.csb.srdbms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

import dls.csb.srdbms.model.StudentBean;

@WebServlet("/listrecords.action")
public class ListAllRecordsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//get the ResultSet from the bean - means records
		ResultSet records = new StudentBean().getRecords();
		
		if (records != null) {
			//perform data binding on request
			request.setAttribute("record", records);
			
			System.out.println("record is not null.");
			
			//forward this to a JSP page to view all decrypted records
			request.getRequestDispatcher("viewrecords.jsp")
				.forward(request, response);
		} else {
			System.err.println("record is null.");
		}
		
		
		
		
	}
}
