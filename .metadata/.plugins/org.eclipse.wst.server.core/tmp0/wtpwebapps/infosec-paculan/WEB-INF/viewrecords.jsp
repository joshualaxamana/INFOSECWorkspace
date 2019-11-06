<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import = "utility.Security"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="record" type="java.sql.ResultSet" scope="request"/>
<html>
<head>

<title>View Records</title>
</head>
<body>
<h1>Investor Records</h1>
<table class="table table-striped">
<tr>
 	<th>ID</th> 
 	<th>First Name</th> 
 	<th>Last Name</th> 
	<th>Amount Invested</th>
	<th>Fund Type</th> 
	<th>NAVPS</th> 
 	<th>Sales Load Amount</th> 
	<th>Net Amount Invested</th>
	<th>Number of Shares</th> 
</tr>
<% while (record.next()){ 
%>
<tr>
	<td> <%= record.getString("investorID") %></td>
	<td><%= Security.decrypt(record.getString("investorFirstName")) %></td>
	<td><%= Security.decrypt(record.getString("investorLastName")) %></td>
	<td> <%=record.getFloat("investAmount") %></td>
	<td><%= Security.decrypt(record.getString("fundType")) %></td>
	<td><%= record.getFloat("navps") %></td>
	<td><%= record.getFloat("salesLoadAmount") %></td>
	<td><%= record.getFloat("netAmount") %></td>
	<td><%= record.getInt("totalShares") %></td>
</tr>
<% }  %> 

<form action='index.jsp'>
<input type="submit" value="<< GO BACK >>">
</form>

</table>
</body>
</html>