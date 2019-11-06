package col.financial.model;

import java.sql.*;

import col.financial.utility.Security;

public class InvestorBean {

	//input values
	private String name;
	private String companyCode;
	private double amount;
	
	//computed values
	private String companyName;
	private int stocksPurchased;
	
	//create setter and getter methods
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public int getStocksPurchased() {
		return stocksPurchased;
	}
	public void setStocksPurchased(int stocksPurchased) {
		this.stocksPurchased = stocksPurchased;
	}
	
	//business logic methods for buying stock market shares
	public void buyStocks() {
		switch (companyCode) {
			case "AC":
				this.companyName = "Ayala Corporation";
				this.stocksPurchased = (int)(this.amount / 1061.00);
				break;
			case "ALI":
				this.companyName = "Ayala Land Incorporated";
				this.stocksPurchased = (int)(this.amount / 44.00);
				break;
			case "BPI":
				this.companyName = "Bank of the Philippine Islands";
				this.stocksPurchased = (int)(this.amount / 95.60);
				break;
			case "GLO":
				this.companyName = "Globe Telecommunications";
				this.stocksPurchased = (int)(this.amount / 2030.00);
				break;
			case "JFC":
				this.companyName = "Jollibee Foods Corporation";
				this.stocksPurchased = (int)(this.amount / 248.20);
				break;
			case "MER":
				this.companyName = "Meralco";
				this.stocksPurchased = (int)(this.amount / 290.20);
				break;
			case "TEL":	
				this.companyName = "Philippine Long Distance Telephone Company";
				this.stocksPurchased = (int)(this.amount / 1660.00);
				break;
		}
		insertToDB();
	}	
	
	//this section is reserved for JDBC database table manipulation
	private Connection getConnectionDB() {
		Connection connection = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			connection = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/laxamana-tc001-infosec",
					"root", "");
		} catch (ClassNotFoundException cfne) {
			cfne.printStackTrace();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return connection;
	}
	
	private void insertToDB() {
		String sql = "insert into colstockmarket (investorName, amountInvested, "
			+ "companyCode, companyName, sharesBought) values (?,?,?,?,?)";
		
		Connection connection = getConnectionDB();
		if (connection != null) { //means that the connection object is valid
			try {
				PreparedStatement pstmnt = connection.prepareStatement(sql);
				
				//set the values according to the parameterized 
				//query of PreparedStatement
				pstmnt.setString(1, Security.encrypt(this.name));
				pstmnt.setDouble(2, this.amount);
				pstmnt.setString(3, Security.encrypt(this.companyCode));
				pstmnt.setString(4, Security.encrypt(this.companyName));
				pstmnt.setInt(5, this.stocksPurchased);
				
				//now commit this to the database table
				pstmnt.executeUpdate();
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			}
		} else {
			System.err.println("Connection object is null.");
		}
	}
	
	public ResultSet getAllRecords() {
		ResultSet records = null;
		
		String sql = "select * from colstockmarket";
			
		Connection connection = getConnectionDB();
		
		if (connection != null) { //means that the connection object is valid
			try {
				PreparedStatement pstmnt = connection.prepareStatement(sql);
				
				//now commit this to the database table
				records = pstmnt.executeQuery();
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			}
		} else {
			System.err.println("Connection object is null.");
		}
		return records;
	}
}
