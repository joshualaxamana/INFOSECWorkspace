package machine.problem.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import machine.problem.model.InvestorBean;

@WebServlet("/processmutualfund.action")
public class ProcessMutualFundServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init() throws ServletException {
		//this is where we will initialize the JDBC Connection object
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//retrieve input and selected values from the form submitted by the user
		String investorName = request.getParameter("name");
		double amountInvested = Double.parseDouble(request.getParameter("amount"));
		String fundCode = request.getParameter("type");
		
		//now create an instance of JavaBean - but where is the bean?
		InvestorBean investor = new InvestorBean();
		
		//call the setter methods coming from input
		investor.setName(investorName);
		investor.setFundType(fundCode);
		investor.setAmount(amountInvested);
		
		investor.buyFunds();
		
		//perform object binding into request object
		request.setAttribute("investor", investor);
		
		//select the JSP for view
		request.getRequestDispatcher("purchasedetails.jsp")
			.forward(request, response);
	}
}
