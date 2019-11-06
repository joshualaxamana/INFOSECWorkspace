package col.financial.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import col.financial.model.InvestorBean;

@WebServlet("/processpurchasestocks.action")
public class ProcessPurchaseStocksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init() throws ServletException {
		//this is where we will initialize the JDBC Connection object
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//retrieve input and selected values from the form submitted by the user
		String investorName = request.getParameter("investor");
		String companyCode = request.getParameter("company");
		double amountInvested = Double.parseDouble(request.getParameter("amount"));
		
		//now create an instance of JavaBean - but where is the bean?
		InvestorBean investor = new InvestorBean();
		
		//call the setter methods coming from input
		investor.setName(investorName);
		investor.setCompanyCode(companyCode);
		investor.setAmount(amountInvested);
		
		investor.buyStocks();
		
		//perform object binding into request object
		request.setAttribute("investor", investor);
		
		//select the JSP for view
		request.getRequestDispatcher("purchasedetails.jsp")
			.forward(request, response);
	}
}
