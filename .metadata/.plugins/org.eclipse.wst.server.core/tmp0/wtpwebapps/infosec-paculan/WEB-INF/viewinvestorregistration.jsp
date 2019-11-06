<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome</title>

<link rel="stylesheet" href="css/minimal.css">
</head>
<body>

        <h1>Registered!</h1>
	</div>
<p>Last Name: <b>${investor.investorLastName}</b></p>
<p>First Name: <b>${investor.investorFirstName}</b></p>
<p>Fund Type: <b>${investor.fundType}</b></p>
<p>Amount Invested:  <b>${investor.investAmount}</b></p>
<p>NAVPS: <b>Php ${investor.navps} (as of November 17, 2017)</b></p>
<p>Sales Load Amount: <b>${investor.salesLoadAmount}</b></p>
<p>Net Amount Invested:  <b>${investor.netAmount}</b></p>
<p>Total Number of Shares:  <b>${investor.totalShares}</b></p>
<hr/>
<p><form action='ListAllRecordsServlet'>
<button class="btn btn-3" type="submit">View Records</button>
</form>
<hr/>
<form action='index.jsp'>
<button class="btn btn-3"  type="submit"> GO BACK</button>
</form>

</body>
</html>