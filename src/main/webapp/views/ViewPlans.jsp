<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Plans</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.js"></script>
  
<style>
.column {
	text-align: right;
	width: 30%;
	padding: 5px;
	text-decoration: underline;
}

.center {
	margin: auto;
	width: 60%;
	text-align: center;
}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	

</head>
<body>
<jsp:include page="header.jsp"/>
<br>


	<table class="table table-bordered table-striped table-hover center">
		<thead class="thead-dark">
			<tr>
				<th scope="col">Plan Id</th>
				<th scope="col">Plan Name</th>
				<th scope="col">Plan Description</th>
				<th scope="col">Plan Start Date</th>
				<th scope="col">Plan End Date</th>
				<th scope="col">Actions</th>
			</tr>
		</thead>
		<tbody>
			 <c:forEach items="${plans}" var="plan">
				<tr>
					<th>${plan.planId}</th>
					<th>${plan.planName}</th>
					<td>${plan.planDescription}</td>
					<td>${plan.startDate}</td>
					<td>${plan.endDate}</td>
					<td><a class="btn btn-primary"
						href="/editPlan?aid=${plan.planId}" role="button">Edit</a>
						<c:set var="status" value="${plan.planStatus}"/>
						
						<c:if test = "${status=='Active'}">
						 <a
						class="btn btn-danger" href="/deletePlan?pid=${plan.planId}"
						role="button"
						onclick="return confirm('Are you sure? \nYou want to Delete ${plan.planId}')">Delete</a>
						</c:if>
						<c:if test = "${status=='Deactivated'}">
						 <a
						class="btn btn-danger" href="/activatePlan?pid=${plan.planId}"
						role="button"
						onclick="return confirm('Are you sure? \nYou want to Activate ${plan.planId}')">Activate</a>
						</c:if>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>



</body>
</html>