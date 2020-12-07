<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
$(document).ready(function() {
	
	$("#userEmail").blur(function() {			
		$("#err").text("");
		$.ajax({
			type : "GET",
			url : "uniqueMailCheck?email=" + $("#userEmail").val(),
			success : function(data) {
				if (data == "DUPLICATE") {
					$("#err").text("Duplicate Email");
					$("#submitBtn").prop("disabled", true);
					console.log(data);
				} else {
					$("#submitBtn").prop("disabled", false);
					console.log(data);
				}
			}

		});
	});	
});
</script>
<meta charset="ISO-8859-1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Register User</title>
<style>

.center {
	max-width: 350px;
	margin: auto;
	padding: 10px;
	text-align: center;
}

.content {
	max-width: 100%;
	margin: auto;
	background: white;
	padding: 30px;
	text-align: left;
	position: relative;
	zoom: 100%;
}
.allText{
font-size: 20px; 
padding: 10px;"
}
</style>
</head>
<body>
<jsp:include page="header.jsp"/>
<br>

	<div class="content">
		<h1 align="center" style="font-size: 50px;">Register User</h1>
		<hr>
		<font color="red">${failMsg}</font> <font color="Green">${succMsg}</font>
		<form:form class="center form-horizontal" action="Register"
			method="POST" modelAttribute="user">
			
			<form:input type="hidden" path="employeeId" />
			<table style="text-align:left;"  cellpadding = "5" cellspacing = "6"  class="allText">

				<tr >
				<td >First Name:</td>
					<td><form:input placeholder="" class = "form-control" type="text" path="firstName"
							required="required" /></td>
				</tr>
				<tr>
					<td >Last Name:</td>
					<td><form:input class = "form-control" type="text" path="lastName"
							required="required" /></td>
				</tr>
				<tr>
					<td>Email :</td>
					<td><form:input class = "form-control" path="email" id="userEmail" /><font
						color="red"><span id="err"></span></font></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><form:input class = "form-control" type="password" path="pazzword" required="required" /></td>
				</tr>
				<tr>
					<td>Date Of Birth:</td>
					<td><form:input class = "form-control" type="date" path="dob" required="required" /></td>
				</tr>
				<tr>
					<td>Gender :</td>
					<td><form:radiobutton  path="gender" value="M" style="font-size: 20px; padding: 10px;"/>  Male   <form:radiobutton
							path="gender" value="F" />  Female</td>
				</tr>
				<tr>
					<td>SSN No. :</td>
					<td><form:input class = "form-control" path="ssnNumber" required="required" /></td>
				</tr>
				<tr>
					<td>Phone Number :</td>
					<td><form:input class = "form-control" path="phoneNumber" required="required" /></td>
				</tr>
				<tr>
					<td>Role :</td>
					<td><form:select class = "form-control" path="role" >
							<form:option value="Admin">Admin</form:option>
							<form:option value="Case Worker">Case Worker</form:option>
						</form:select></td>
				</tr>
				<tr>
					<td></td>
					<td><br>
					<input class="btn btn-primary" type="submit" value="Register" id="submitBtn" /></td>
				</tr>
			</table>

		</form:form>

	</div>
</body>
</html>