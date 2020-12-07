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
<title>Educational Details</title>
</head>
<body>
<jsp:include page="header.jsp"/>


<br>
<br>
<div style="margin:auto;max-width:400px" class="card bg-light text-dark card-body">
<h1>Educational Details</h1>
<form:form action="saveEducationDetails" method = "POST" modelAttribute="dcEducation">
<table style="font-weight: bold; border-collapse: separate; border-spacing: 0 1em;"	id="myTable">
<tr><td>Case Id :</td><td><form:input type="text" readonly="true" path="caseId" value="${dcEducation.caseId}"/></td></tr>
<tr><td>Indivisual's Name :</td><td><form:input readonly="true" type="text" path="name" value="${dcEducation.name}"/></td></tr>
<tr><td>Highest Qualification :</td><td><form:select  path="highestQualification" value="Yes">
<form:option value="10+2">10+2</form:option>
<form:option value="Bachelor's Degree">Bachelor's Degree</form:option>
<form:option value="Honour's Degree">Honour's Degree</form:option>
<form:option value="Master's Degree">Master's Degree</form:option>
<form:option value="Doctoral Degree">Doctoral Degree</form:option>
</form:select></td></tr>
<tr><td>Completed Year: </td><td><form:input type="text" path="completedYear" /></td></tr>
<tr><td>Grade : </td><td><form:select type="text" path="grade">
<form:option value="A+">A+</form:option>
<form:option value="A">A</form:option>
<form:option value="B+">B+</form:option>
<form:option value="B">B</form:option>
<form:option value="C+">C</form:option>
<form:option value="D+">D+</form:option>
<form:option value="D">D</form:option>
</form:select></td></tr>
<tr><td></td><td><br><input class="btn btn-primary" type="submit" value="Next" id="submitBtn" /></td></tr>
</table>

</form:form>
</div>


</body>
</html>