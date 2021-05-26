 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>History</title>
<style>
table, th, td {
  border: 1px solid black;
}
</style>
</head>
<body style="background:skyblue">
	<br>
	<h1>Balance: ${th1}</h1>
<table align="center"><tr><td><h2>Your Transaction Details</h2></td></tr><br></table><br>
<table  width=35% align="center">
		
	   
	    
		<tr>
			<th>TransactionId&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
			<th>Date-of-Transaction&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
			<th>From AccountId&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
			
			<th>AmountTransfered&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
			<th>BalanceAfterTransaction&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
			<th>AccountType&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
			<th>TransferedTo&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
		
		</tr>
		<br>
		<br>
		 
		 <c:forEach var="s" items="${th}">
			<tr>
				<td>${s.tid}</td>
				<td>${s.date}</td>
				<td>${s.faccno}</td>
				<td>${s.amount}</td>
				<td>${s.bal}</td>
				<td>${s.acctype}</td>
				<td>${s.taccno}</td>
				
				
				
				
			</tr>
		</c:forEach>
				
	</table>
</body>
</html>