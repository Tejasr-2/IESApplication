<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<title>Applicant Registration</title>
<style>

.center {
	max-width: 350px;
	margin: auto;
	padding: 10px;
	text-align: center;
}

.content {
	max-width: 900px;
	margin: auto;
	background: white;
	padding: 30px;
	text-align: center;
	position: relative;
	zoom: 100%;
}
.allText{
font-size: 20px; 
padding: 10px;"
}
</style>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
	<jsp:include page="header.jsp"/>
	
	<br>

	<div class="content">
		<h1 align="center" style="font-size: 50px;">Register Application</h1>
		<hr>
		<font color="red">${failMsg}</font> <font color="Green">${succMsg}</font>
		<form:form class="center form-horizontal" action="/RegisterApplication"
			method="POST" modelAttribute="application">

			<form:input type="hidden" path="applicationId" />
			<table class="allText">

				<tr>
					<td>First Name :</td>
					<td><form:input type="text" path="firstName"
							required="required" /></td>
				</tr>
				<tr>
					<td>Last Name:</td>
					<td><form:input type="text" path="lastName"
							required="required" /></td>
				</tr>
				<tr>
					<td>Date Of Birth:</td>
					<td><form:input type="date" path="dob" required="required" /></td>
				</tr>
				<tr>
					<td>Gender :</td>
					<td><form:radiobutton path="gender" value="M" /> Male 
					    <form:radiobutton path="gender" value="F" /> Female</td>
				</tr>
				<tr>
					<td>SSN No. :</td>
					<td><form:input path="ssnNumber" required="required" type = "number" /></td>
				</tr>
				<tr>
					<td>Phone Number :</td>
					<td><form:input path="phoneNumber" required="required" /></td>
				</tr>
				<tr>
					<td>Email :</td>
					<td><form:input path="email" /></td>
				</tr>
				<tr>
					<td></td>
					<td><br> <input class="btn btn-primary" type="submit"
						value="Register" id="submitBtn" /></td>
				</tr>
			</table>

		</form:form>

	</div>



</body>
</html>