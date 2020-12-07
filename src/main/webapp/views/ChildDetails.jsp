<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

  
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
<title>Child Details</title>
</head>
<body>
<jsp:include page="header.jsp"/>


<br>
<br>
<div style="margin:auto;max-width:40%" class="card bg-light text-dark card-body">
<h1>Income Details</h1>
<form:form action="addChild" method = "POST" modelAttribute="dcChild">
<table style="font-weight: bold; border-collapse: separate; border-spacing: 0 1em;"	id="myTable">
<tr><td>Case Id :</td><td><form:input type="text" path="caseId" readonly="true" value="${dcChild.caseId}"/></td></tr>
<tr><td>Indivisual's Name :</td><td><form:input type="text" readonly="true" path="parentName" value="${dcChild.parentName}"/></td></tr>
<tr><td>Child Name :</td><td><form:input type="text" path="childName" required="required" placeholder="Enter Child's Name"/></td></tr>
<tr><td>Gender :</td><td><form:radiobutton  path="gender" value="Male"/> Male <form:radiobutton  path="gender" value="Female"/> Female </td></tr>
<tr><td>Child's DOB : </td><td><form:input type="date" path="dob" required="required" /></td></tr>
<tr><td>Child's SSN : </td><td><form:input type="number" path="ssnNumber"  required="required"/></td></tr>
<tr><td></td><td><br><input class="btn btn-primary" type="submit" value="Add Child" id="submitBtn" /></td></tr>
</table>
</form:form>

<table class="table table-bordered table-striped table-hover center">
    <thead class="thead-dark">
      <tr>
        <th scope="col">S No.</th>
        <th scope="col">Child ID</th>
        <th scope="col">Child Name</th>
        <th scope="col">Gender</th>
        <th scope="col">DOB </th>
        <th scope="col">SSN</th>
        <th scope="col">Actions</th>
      </tr>
    </thead>
    <tbody>
       <c:forEach items="${children}" var="child" varStatus="loop">
        <tr>
          <th>${loop.count}</th>
          <th>${child.childId}</th>
          <td>${child.childName}</td>
          <td>${child.gender}</td>
          <td>${child.dob}</td>
          <td>${child.ssnNumber}</td>
          <td><a class="btn btn-primary"
            href="/editChild?cid=${child.childId}" role="button">Edit</a>
             <a class="btn btn-danger" href="/deleteChild?cid=${child.childId}"
            role="button"
            onclick="return confirm('Are you sure? \nYou want to Delete ${child.childId}')">Delete</a>
          </td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
  <a style="align:left" class="btn btn-primary" href="/Eligibility" role="button">Next</a>
  
</div>


</body>
</html>