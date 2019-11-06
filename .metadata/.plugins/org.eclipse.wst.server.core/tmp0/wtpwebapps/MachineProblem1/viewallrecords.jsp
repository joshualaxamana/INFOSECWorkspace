<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="machine.problem.utility.Security"%>
    
<jsp:useBean id="record" type="java.sql.ResultSet" scope="request"/>
    
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
	<table border="1">
		<tr>
			<th>ID</th>
			<th>Investor Name</th>
			<th>Code</th>
			<th>Fund Type</th>
			<th>Amount</th>
			<th>NAVPS</th>
			<th>Sales Load</th>
			<th>Net Amount Invested</th>
			<th>Shares Bought</th>
		</tr>
		<%
			while (record.next()) {
		%>
			<tr align="center">
				<td><%= record.getInt("id") %></td>
				<td><%= Security.decrypt(record.getString("investorName")) %></td>
				<td><%= Security.decrypt(record.getString("fundCode")) %></td>
				<td><%= Security.decrypt(record.getString("mutualFundType")) %></td>
				<td><%= record.getDouble("amountInvested") %></td>
				<td><%= record.getDouble("navps") %></td>
				<td><%= record.getDouble("salesLoad") %></td>
				<td><%= record.getDouble("netAmountInvested") %></td>
				<td><%= record.getInt("sharesBought") %></td>
			</tr>
		<% } %>		
	</table>
	<hr/>
	<form action="index.jsp">
		<input class="btn btn-success" type="submit" value=" << GO BACK >>">
	</form>
</body>
</html>