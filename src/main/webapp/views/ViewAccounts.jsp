<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Users</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
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
<script>
	$(document).ready(function() {
		$("#roles").val(document.getElementById("userRole").innerHTML);
	$("#roles").change(function(){
		$('tbody').html('');
		$.ajax({
			type : "GET",
			url : "getUsersByRole?role=" + $("#roles").val(),
			success : function(data) {
				var row='<tr>';
				
				$.each(data, function(i, acc) {
							
					      row+='<td>'+acc.employeeId+'</td>';
					      row+='<td>'+acc.firstName+'</td>';
					      row+='<td>'+acc.lastName+'</td>';
					      row+='<td>'+acc.email+'</td>';
					      row+='<td>'+acc.role+'</td>';
					      row+= '<td>'+
							'<a class="btn btn-primary" '+ 
								'href="/editUser?uid='+acc.employeeId+'" role="button">Edit </a>';
							if(acc.accStatus == "Active")
								{
								row+= '<a class="btn btn-danger" href="/deleteUser?uid='+ acc.employeeId +'" role="button" onclick="return myfunDel(\'' + acc.firstName +'\')"> Delete </a>';
								}
							else{
								row+= ' <a class="btn btn-danger" href="/activateUser?uid='+ acc.employeeId +'" role="button"	onclick="return myfunAct(\''+acc.firstName+'\')"> Activate </a> ';
								}
							
						   row+='</td></tr>';
					   
					   $('tbody').append(row);
					   row='<tr>'
					});
			}

		});
		
		
	});
		
	});
	
	function myfunDel(name){
		return confirm('Are you sure? \nYou want to Delete '+ name + '?');
		
	};
	function myfunAct(name){
		return confirm('Are you sure? \nYou want to Activate '+ name + '?');
		
	};

	</script>
</head>
<body>
<jsp:include page="header.jsp"/>
	<br>



	<br>
	<br>
	<span>Roles :</span>
	<select class="column form-control" name="roles" id="roles">
		
		<option value="Admin">Admin</option>
		<option value="Case Worker">Case Worker</option>
	</select>
	<br>
	<br>

	<table class="table table-bordered table-striped table-hover center">
		<thead class="thead-dark">
			<tr>
				<th scope="col">User Id</th>
				<th scope="col">First Name</th>
				<th scope="col">Last Name</th>
				<th scope="col">Email</th>
				<th scope="col">Role</th>
				<th scope="col">Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${users}" var="user" varStatus="loop">
				<tr>
					<th>${user.employeeId}</th>
					<td>${user.firstName}</td>
					<td>${user.lastName}</td>
					<td>${user.email}</td>
					<td id="userRole">${user.role}</td>
					<td><a class="btn btn-primary"
						href="/editUser?uid=${user.employeeId}" role="button">Edit</a> <c:set
							var="status" value="${user.accStatus}" /> <c:if
							test="${status=='Active'}">
							<a class="btn btn-danger"
								href="/deleteUser?uid=${user.employeeId}" role="button"
								onclick="return myfunDel('${user.firstName}')">Delete</a>
						</c:if> <c:if test="${status == 'Deactivated'}">
							<a class="btn btn-danger"
								href="/activateUser?uid=${user.employeeId}" role="button"
								onclick="return myfunAct('${user.firstName}')">Activate</a>
						</c:if></td>
				</tr>
			</c:forEach> 
		</tbody>
	</table>



</body>
</html>