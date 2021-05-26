<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>cheque book request</title>
</head>
<body style="background:skyblue">
	<h2>${msg}</h2>
	<form action="requestcheques" method="post">
		<h2>Request Cheque Book</h2>
		<br>
		<br>
		
		<div>
			Your Account Number:<input type="text" name="cid">
			
		</div>
		<br>
		<input type="submit" value="Request Cheque Book">
	</form>

</body>
</html>