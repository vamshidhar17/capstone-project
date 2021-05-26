<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Users Information</title>
<style>
table, th, td {
  border: 1px solid black;
}
</style>
</head>
<body style="background:skyblue">
	<table align="center" class="table"><tr><td><h2>Users Details</h2></td></tr><br></table><br>
<table  width=35% align="center">
		
	   
	    
		<tr>
			<th>Account Number</th>
			<th>Full Name</th>
			<th>User Name</th>
			<th>Account Type</th>
			<th>Balance</th>
			<th>Aadhar Number</th>
			<th>email</th>
			<th>Phone</th>
			<th>DOB</th>
			<th>gender</th>
			<th>Address</th>
			<th>Country</th>
			<th>Transaction</th>
			<th>Deposit</th>
			<th>Block User</th>
			
		
		</tr>
		<br>
		<br>
		 
		 <c:forEach var="s" items="${th}">
			<tr>
				<td>${s.acc_num}</td>
				<td>${s.fullname}</td>
				<td>${s.username}</td>
				<td>${s.type}</td>
				<td>${s.balance}</td>
				<td>${s.aadhar}</td>
				<td>${s.email}</td>
				<td>${s.phone}</td>
				<td>${s.dob}</td>
				<td>${s.gender}</td>
				<td>${s.address}</td>
				<td>${s.country}</td>
				
					
					<form action="admintrans/${s.acc_num}/${s.trans_status}"><td align="center"><input type="submit" name="trans" value="${s.trans_status}"></td></form>
					<form action="admintrans/deposite/${s.acc_num}/${s.deposit_status}"><td align="center"><input type="submit" name="deposit" value="${s.deposit_status}" ></td></form>
					<form action="admintrans/block/${s.acc_num}/${s.blocked}"><td align="center"><input type="submit" name="block"  value="${s.blocked}"></td></form>
					
				
				
				
				
				
				
				
				
			</tr>
		</c:forEach>
				
	</table>

</body>
</html>