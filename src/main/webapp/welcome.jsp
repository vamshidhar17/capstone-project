<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<h1>${msg }</h1>
<body style="background:skyblue">
<h1>welcome to ICIN BANK</h1>
<br>
<br>
<br>
<h3>Already have an account? click on below login button to login to your account</h3>
<form action="login.jsp">
	<input value="Login" type="submit">
</form>
<br>
<br>
<h3>Don't have a account?</h3>
<br>
<form action="register.jsp">
	<input value="register" type="submit">
</form>


</body>
</html>