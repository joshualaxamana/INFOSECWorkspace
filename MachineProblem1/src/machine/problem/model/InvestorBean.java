package machine.problem.model;

import java.sql.*;

import machine.problem.utility.Security;

public class InvestorBean {

	private String name;
	private String fundType;
	private double amount;
	private String fundTypeName;
	private double percentage;
	private double navsp;
	private double salesLoad;
	private double netAmountInvested;
	private int sharesBought;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFundType() {
		return fundType;
	}

	public void setFundType(String fundType) {
		this.fundType = fundType;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getFundTypeName() {
		return fundTypeName;
	}

	public void setFundTypeName(String fundTypeName) {
		this.fundTypeName = fundTypeName;
	}

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

	public double getNavsp() {
		return navsp;
	}

	public void setNavsp(double navsp) {
		this.navsp = navsp;
	}

	public double getSalesLoad() {
		return salesLoad;
	}

	public void setSalesLoad(double salesLoad) {
		this.salesLoad = salesLoad;
	}

	public double getNetAmountInvested() {
		return netAmountInvested;
	}

	public void setNetAmountInvested(double netAmountInvested) {
		this.netAmountInvested = netAmountInvested;
	}

	public int getSharesBought() {
		return sharesBought;
	}

	public void setSharesBought(int sharesBought) {
		this.sharesBought = sharesBought;
	}

	
	//business logic methods for buying stock market shares
	public void buyFunds() {
		if (this.amount > 999 || this.amount < 100000) {
			this.percentage = 0.02;
		}
		else if (this.amount >= 100000 || this.amount < 500000) {
			this.percentage = 0.015;
		}
		else if (this.amount >= 500000 || this.amount < 2000000) {
			this.percentage = 0.01;
		}
		else if (this.amount >= 2000000) {
			this.percentage = 0.005;
		}
		
		switch (fundType) {
			case "SALEF":
				this.fundTypeName = "Save and Learn Equity Fund";
				this.navsp = 5.8222;
				this.salesLoad = this.percentage * this.amount;
				this.netAmountInvested = this.amount - this.salesLoad;
				this.sharesBought = (int)((this.amount - this.salesLoad) / this.navsp);
				break;
			case "SALBF":
				this.fundTypeName = "Save and Learn Balanced Fund";
				this.navsp = 2.7205;
				this.salesLoad = this.percentage * this.amount;
				this.netAmountInvested = this.amount - this.salesLoad;
				this.sharesBought = (int)((this.amount - this.salesLoad) / this.navsp);
				break;
			case "SALFIF":
				this.fundTypeName = "Save and Learn Fixed Income Fund";
				this.navsp = 2.2136;
				this.salesLoad = this.percentage * this.amount;
				this.netAmountInvested = this.amount - this.salesLoad;
				this.sharesBought = (int)((this.amount - this.salesLoad) / this.navsp);
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
		String sql = "insert into famiinvestors (investorName, amountInvested, "
			+ "fundCode, mutualFundType, navps, netAmountInvested, salesLoad, sharesBought) "
			+ "values (?,?,?,?,?,?,?,?)";
		
		Connection connection = getConnectionDB();
		if (connection != null) { //means that the connection object is valid
			try {
				PreparedStatement pstmnt = connection.prepareStatement(sql);
				
				//set the values according to the parameterized 
				//query of PreparedStatement
				pstmnt.setString(1, Security.encrypt(this.name));
				pstmnt.setDouble(2, this.amount);
				pstmnt.setString(3, Security.encrypt(this.fundType));
				pstmnt.setString(4, Security.encrypt(this.fundTypeName));
				pstmnt.setDouble(5, this.navsp);
				pstmnt.setDouble(6, this.netAmountInvested);
				pstmnt.setDouble(7, this.salesLoad);
				pstmnt.setInt(8, this.sharesBought);
				
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
		
		String sql = "select * from famiinvestors";
			
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