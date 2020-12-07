<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
<title>Income Details</title>
</head>
<body>
<jsp:include page="header.jsp"/>


<br>
<br>
<div style="margin:auto;max-width:400px" class="card bg-light text-dark card-body">
<h1>Income Details</h1>
<form:form action="caseIncomeDetails" method = "POST" modelAttribute="dcIncome">
<table style="font-weight: bold; border-collapse: separate; border-spacing: 0 1em;"	id="myTable">
<tr><td>Case Id :</td><td><form:input readonly="true" type="text" path="caseId" value="${dcIncome.caseId}"/></td></tr>
<tr><td>Indivisual's Name :</td><td><form:input readonly="true" type="text" path="name" value="${dcIncome.name}"/></td></tr>
<tr><td>Is Working Employee :</td><td><form:radiobutton  path="workStatus" value="Yes"/> Yes <form:radiobutton  path="workStatus" value="No"/> No </td></tr>
<tr><td>Other Income: </td><td><form:input type="text" path="otherIncome" /></td></tr>
<tr><td></td><td><br><input class="btn btn-primary" type="submit" value="Next" id="submitBtn" /></td></tr>
</table>

</form:form>
</div>


</body>
</html>