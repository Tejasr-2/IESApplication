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
<meta charset="ISO-8859-1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Register User</title>
<style>
.column {
	text-align: center;
	width: 70%;
	padding: 5px;
	text-decoration: underline;
}

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
</head>

<body>
<jsp:include page="header.jsp"/>
<br>

	<div class="content">
		<h1 align="center" style="font-size: 50px;">Register Plan</h1>
		<hr>
		<font color="red">${failMsg}</font> <font color="Green">${succMsg}</font>
		<form:form class="center form-horizontal" action="RegisterPlan"
			method="POST" modelAttribute="plan">
			
			<form:input type="hidden" path="planId"  />
			<table class="allText">

				<tr >
					<td >Plan Name :</td>
					<td><form:input type="text" path="planName"
							required="required" /></td>
				</tr>
				<tr>
					<td >Plan Description:</td>
					<td><form:input type="text" path="planDescription"
							required="required" /></td>
				</tr>
				<tr>
					<td>Plan Start Date:</td>
					<td><form:input type="date" path="startDate" required="required" /></td>
				</tr>
				<tr>
					<td>Plan End Date:</td>
					<td><form:input type="date" path="endDate" required="required" /></td>
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