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
	
	<fieldset>
		<legend>Investment Purchase Form</legend>
		<form action='processpurchasestocks.action' method='post'>
			<p>Enter Investor Name:
				<input type='text' name='investor' id='investor' 
					size='50' required="required"/>
			</p>
			<p>Select Company:
				<select name='company' id='company'>
					<option value="AC">Ayala Corporation</option>
					<option value="ALI">Ayala Land Incorporation</option>
					<option value="BPI">Bank of the Philippine Islands</option>
					<option value="GLO">Globe Telecommunications</option>
					<option value="JFC">Jollibee Foods Corporations</option>
					<option value="MER">Meralco</option>
					<option value="TEL">Philippine Long Distance and Tel Co</option>
				</select>
			</p>
			<p>Amount to Invest: Php 
				<input type="number" name='amount' id='amount' 
					min="5000" max="10000000" required="required"/>
			</p>
			<p>
				<input type="submit" value='Buy Stocks'/>&nbsp;&nbsp;&nbsp;
				<input type="reset"/>
			</p>
		</form>
	</fieldset>
	<hr/>
	<form action="listrecords.action">
		<input type="submit" value="View ALL Records">
	</form>
</body>
</html>