<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transactions</title>
</head>
<body style="background:skyblue">
	<h1> ${msg}</h1>
	<h2>Money Transfer</h2>
	<form action="/transfer" method="post">
	
	<h4>Please enter your account number</h4>
	
	<div>
		<h4>Account Number:&emsp;<input type="text" name="s_acc"></h4>
	</div>
	
	<div>
		<h4>password:&emsp;<input type="password" name="pass"></h4>
	</div>
	
	<div>
		<h4>Receiver account number:&emsp;<input type="text" name="r_acc"></h4>
	</div>
	
	<div>
		<label>Account Type :</label>
			<input type="radio" name="type" value="primary"/> Primary
			<input type="radio"  name="type" value="savings"/> Savings  
			<br><br>   
		<label>
	</div>
		
	
	<div>
		<h4>Receiver Name:&emsp;<input type="text" name="name"></h4>
	</div>
		
	
	<div>
		<h4>Amount:&emsp;<input type="text" name="amount"></h4>
	</div>
	
	
	<div>
		<input type="submit">
	</div>
		
	
	
	</form>

</body>
</html>