<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html >
<head>
<meta charset="ISO-8859-1">
<title>login</title>
</head>
<body style="background:skyblue">
     <h1>${msg}</h1>
	<h3>Enter your details.</h3>
	<form action="logging" method=post>
		<div>
			Account Number: <input type="text" name="cid">
		
		</div>
		<br>
		<div>
			Password:<input type="password" name="pass">
		</div>
		<br>
		<input type="submit">
		
	
	
	</form>
	

	<h3>Don't have a account?</h3>
	<form action="register.jsp">
		<input value="register" type="submit">
	</form>
    
</body>
</html>