<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Machine Problem - Mutual Fund</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<h2>Machine Problem - Mutual Fund</h2>
	
	<h3>Mutual Fund Details</h3>
	<p>Investor Name is <b>${investor.name}</b></p>
	<p>Investment Fund Type is <b>${investor.fundTypeName}</b></p>
	<p>Amount Invested is <b>Php ${investor.amount}</b></p>
	<p>NAVSP: <b>Php ${investor.navsp} (as of November 16, 2017)</b>
	<p>Sales Load Amount: <b>Php ${investor.salesLoad}</b>
	<p>Net Amount Invested: <b>Php ${investor.netAmountInvested}</b>
	<p>Total Shares Bought: <b>${investor.sharesBought}</b></p>
	
	<form action="listallrecords.action">
		<input class="btn btn-success" type="submit" value="View ALL Records">
	</form>
	
	<hr>
	<form action="index.jsp">
		<input class="btn btn-success" type="submit" value=" << GO BACK >>">
	</form>
	
</body>
</html>