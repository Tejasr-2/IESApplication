<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<script>
	
function applicationCheck(){
	var str2 = $("input:text").val();
	$('table').html('');
	if (str2 == null)
		{
		$("#err").text("Please Enter A Application Number");
		}
	else{
	$.ajax({
		type : "GET",
		url  : "/checkApplicationNumber?applicationNumber=" + str2,
		success : function(app) {
			
			if(app.firstName!= null)
				{
				/* $("#err").text("Seems OK"); */
				
				$("#header").text("Create Case");
				
				var row = '';
				row += '<tr><td>Applicant Id :</td><td>'+app.applicationId+'</td> </tr>';
				row+= '<tr><td>Name :</td><td>'+app.firstName +' '+ app.lastName +' </td></tr>';
				row+= '<tr><td>Date Of Birth :</td><td>'+app.dob+'</td></tr>';
				row+= '<tr><td>Gender :</td><td>'+app.gender+'</td></tr>';
				row+= '<tr><td>SSN :</td><td>'+'xxx-xx-'+app.ssnNumber+'</td></tr>';
				row+= '<tr><td>Phone Number :</td><td>'+app.phoneNumber+'</td></tr>';
				row+= '<tr><td>Email :</td><td>'+ app.email +'</td></tr>';
			
				$('table').append(row);
				$('table').after('<a id="createCaseButton"  role="button" class="btn btn-primary" onclick="createCase()"><b>Create Case</b></a>');
				
				
				
				}
			else{
				$("#err").text("Please Enter Valid Application Number");

			}
			
		}
		
		
		
	});
	}
	
};

function createCase(){
	
	window.location.href = '/PlanSelection?applicationId=' + $("input:text").val();
};



</script>
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
<title>Create Case</title>

</head>
<body>
<jsp:include page="header.jsp"/>
<br>
<br>
<br>
<div class="example"  style="margin:auto;max-width:400px">
  <input type="text" placeholder="Enter Application Number" name="search" id="serachText"/>
  <a  role="button" onclick="applicationCheck()"><i class="fa fa-search"></i></a>
  <br>
  <font color="red"><span id="err"></span></font>
  <br>
  <br>
  <br>
  
  <div class="card bg-light text-dark card-body">
  
  <h1 id="header"></h1>

		
				<table style="font-weight: bold; border-collapse: separate; border-spacing: 0 1em;"	id="myTable">
				
				
				
				</table>
  </div>
</div>
</body>
</html>