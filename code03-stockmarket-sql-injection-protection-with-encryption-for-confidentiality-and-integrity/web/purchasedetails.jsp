<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>COL Financial Philippines</title>
</head>
<body>
	<img src="images/col.jpg">
	<h2>COL Financial Philippines</h2>
	
	<h3>Stock Purchase Details</h3>
	<p>Investor Name: <b>${investor.name}</b></p>
	<p>Stock Company Code: <b>${investor.companyCode}</b></p>
	<p>Stock Company Name: <b>${investor.companyName}</b></p>
	<p>Amount Invested: <b>Php ${investor.amount}</b></p>
	<p>Number of Stocks Purchased: <b>${investor.stocksPurchased}</b></p>
	
	<form action="listrecords.action">
		<input type="submit" value="View ALL Records">
	</form>
	
	<hr>
	<form action="index.jsp">
		<input type="submit" value=" << GO BACK >>">
	</form>
	
</body>
</html>