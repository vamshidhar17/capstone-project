<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Money Deposit</title>
</head>
<body style="background:skyblue">
	<br>
	<div>
		<h2>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;Money Deposit Form&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<a href="Mainmenu.jsp">Home</a></h2>
			
	</div>
	<br>
	<form action="/bankdeposit" method="post">
	
		<div>
			Account NUmber:&emsp;&emsp;&emsp;<input type="text" name="aid">
		</div>
		<br>
		<div>
			Amount:&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<input type="text" name="amount">
		</div>
		<br>
		<div>
			Password:&emsp;&emsp;&emsp;&emsp;&emsp;<input type="password" name="pass">
		</div>
	<br>
	<div>
		<input type="submit">
	</div>
	
	</form>
	
	

</body>
</html>