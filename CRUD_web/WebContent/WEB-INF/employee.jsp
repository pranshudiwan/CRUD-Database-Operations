<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Add new Employee</title>

<meta charset="UTF-8">
<meta name="description" content="Search the database">
<meta name="author" content="Pranshu Diwan">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="stylesheet" type="text/css" href="style.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>


</head>
<body>
	<br>

	<nav class="main-nav">

		<a href="index.jsp">Import</a> <a href="main.jsp">Search / Update
			/ Delete</a> <a href="EmployeeController?action=insert">Insert</a>
			<a href='EmployeeController?action=listEmployees'>List of Employees</a>
	</nav>

	<br>
	<br>
	<br>

	<h2 style="font-family: sans-serif">Hexaware Technologies Ltd.</h2>
	<br>

<div class="box1">
	<form action="EmployeeController" method="POST" name="AddEmployee">
    
        <input type="hidden" name="id" placeholder = "---" readonly 
         value="<c:out value="${employee.id}" />" />
         
        <h4 style = "font-family:sans-serif;">Employee Name : 
        <input type="text" name="name" placeholder = "Employee Name" required pattern="[a-zA-Z ].{0,}" title="Only letters"
        value="<c:out value="${employee.name}" />" /></h4> <br /> 
        
        <h4 style = "font-family:sans-serif;">Mobile Number : 
        <input type="text" name="mobile" placeholder = "Mobile Number" required pattern="[0-9]{10}" title="10 digit number"
         value="<c:out value="${employee.mobile}" />" /> </h4><br />                  
           
        <h4 style = "font-family:sans-serif;">Department: 
        <input type="text" name="dept" placeholder = "Department" required pattern="[a-zA-Z ].{0,}" title="Only letters"
        value="<c:out value="${employee.dept}" />" /></h4> <br /> 
        
        
        <input type="submit" value="Submit" />
    </form>
    </div>
</body>
</html>
