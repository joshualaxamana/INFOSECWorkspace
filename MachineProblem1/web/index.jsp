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
	
	<fieldset>
		<legend>Mutual Fund Form</legend>
		<form action='processmutualfund.action' method='post'>
		<div class="form-group">
		<p>Enter Investor Name:
				<input type='text' name='name' id='name' 
					size='50' required="required"/>
			</p>
			<p>Enter Mutual Fund Type:
				<select name='type' id='type'>
					<option value="SALEF">SALEF</option>
					<option value="SALBF">SALBF</option>
					<option value="SALFIF">SALFIF</option>
				</select>
			</p>
			<p>Enter Investment Amount: Php 
				<input type="number" name='amount' id='amount' 
					min="1000" max="10000000" required="required"/>
			</p>
			<p>
				<input class="btn btn-success" type="submit" value='Buy Mutual Fund'/>&nbsp;&nbsp;&nbsp;
				<input class="btn btn-success"  type="reset"/>
			</p>
		</div>
		</form>
	</fieldset>
	<hr/>
	<form action="listallrecords.action">
	<div class="form-group">
	<input class="btn btn-success" type="submit" value="View ALL Records">
	</div>
	</form>
</body>
</html>