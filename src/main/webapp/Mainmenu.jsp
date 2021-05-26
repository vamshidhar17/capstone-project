<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MainMenu</title>
</head>
<body style="background:skyblue">
<h2>${msg}</h2>
	<div>
		<h1>Welcome to ICIN Bank.</h1>
	</div>
	<br>
	<br>
	<div>
		<h3><a href="/Depositm/${cid}">Deposit</a></h3>
	</div>
	<br>
	<div>
		<h3><a href="/Money/${cid}">Money Transfer</a></h3>
	</div>
	<br>
	<div>
		<h3><a href="transhistory/${cid} ">Balance and Transaction History</a></h3>
	</div>
	<br>
	<div>
		<h3><a href="requestcheque.jsp">Request Cheque books</a></h3>
	</div>
	<br>
	<div>
		<h3><a href="profile/${cid}">profile</a></h3>
	</div>

</body>
</html>