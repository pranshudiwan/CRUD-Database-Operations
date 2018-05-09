<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="description" content="Search the database">
<meta name="author" content="Pranshu Diwan">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="stylesheet" type="text/css" href="style.css">

<title>Search</title>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript" src="validation_script.js"></script>

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

	<h2 style="font-family: sans-serif">Hexaware Technologies Ltd.</h2>
	<br>
	<div class="box1">
		<form action="EmployeeController" method="POST" name="SearchEmployee"  onsubmit="return validate_input()">
			<select name="drop" id="drop">
				<option value="select" selected>--select--</option>
				<option value="id">ID</option>
				<option value="name">Name</option>
				<option value="mobile">Telephone</option>
				<option value="dept">Department</option>
			</select> <input type="text" name="param" placeholder="Enter data here">
			<span id="error" style="color: red;"></span><br> <br> <input
				type="submit" value="Search"/>

		</form>
	</div>

</body>
</html>
