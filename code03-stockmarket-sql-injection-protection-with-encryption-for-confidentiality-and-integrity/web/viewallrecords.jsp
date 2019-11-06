<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="col.financial.utility.Security"%>
    
<jsp:useBean id="record" type="java.sql.ResultSet" scope="request"/>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>COL Financial Philippines</title>
</head>
<body>
	<img src="images/col.jpg">
	<h2>COL Financial Philippines</h2>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>Investor Name</th>
			<th>Code</th>
			<th>Company Name</th>
			<th>Amount</th>
			<th>Shares Bought</th>
		</tr>
		<%
			while (record.next()) {
		%>
			<tr align="center">
				<td><%= record.getInt("id") %></td>
				<td><%= Security.decrypt(record.getString("investorName")) %></td>
				<td><%= Security.decrypt(record.getString("companyCode")) %></td>
				<td><%= Security.decrypt(record.getString("companyName")) %></td>
				<td><%= record.getDouble("amountInvested") %></td>
				<td><%= record.getInt("sharesBought") %></td>
			</tr>
		<% } %>		
	</table>
	<hr/>
	<form action="index.jsp">
		<input type="submit" value=" << GO BACK >>">
	</form>
</body>
</html>