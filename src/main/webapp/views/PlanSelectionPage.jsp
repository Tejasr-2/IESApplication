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
<meta charset="ISO-8859-1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Select Plan</title>
<script>
/* $(document).ready(function() {
	
	$.ajax({
		type : "GET",
		url  : "getActivePlans",
		success: function(activeplans){
			
			$.each(activeplans,function(planName){
				$("#selectPlan").append($("<option>").text(planName).attr("value",planName));
			})
			
		}
	
		
	});
	
	
}); */

</script>

</head>
<body>
<jsp:include page="header.jsp"/>
<br>
<br>
<br>
<div class="example"  style="margin:auto;max-width:400px">
  
  <font color="red"><span id="err"></span></font>
  <br>
  <br>
  <br>
  
  <div class="card bg-light text-dark card-body">
  
  <h1 id="header">Select Plan</h1>

		<form:form  action="saveDCPlan"	method="POST" modelAttribute="dcPlan">
		<table style="font-weight: bold; border-collapse: separate; border-spacing: 0 1em;"	id="myTable">
				<tr >
					<td >Case Id :</td>
					<td><form:input type="text" readonly="true" path="caseId"
							 value="${dcPlan.caseId}"/></td>
				</tr>
				<tr>
					<td >First Name :</td>
					<td><form:input type="text" readonly="true" path="firstName"
							value="${dcPlan.firstName}" /></td>
				</tr>
				<tr>
					<td>Last Name :</td>
					<td><form:input type="text" readonly="true" path="lastName" value="${dcPlan.lastName}" /></td>
				</tr>
				<tr>
					<td>Select Plan:</td>
					<td><form:select path="planName" id="selectPlan">
					<form:options items="${plans}" />
					</form:select></td>
				</tr> 
				
				<tr>
					<td></td>
					<td><br>
					<input class="btn btn-primary" type="submit" value="Next" id="submitBtn" /></td>
				</tr>
			</table>

</form:form>
  </div>
</div>
</body>
</html>