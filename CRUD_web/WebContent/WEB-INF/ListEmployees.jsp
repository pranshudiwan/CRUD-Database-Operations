<%@page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Display All Employees</title>

<meta charset="UTF-8">
<meta name="description" content="Search the database">
<meta name="author" content="Pranshu Diwan">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="stylesheet" type="text/css" href="style.css">

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
	<br>

	<h2 style="font-family: sans-serif">Hexaware Technologies Ltd.</h2>
	<br>

<div class="box1">

    <table>
        <thead>
            <tr>
                <th>Employee Id</th>
                <th>Employee Name</th>
                <th>Mobile Number</th>
                <th>Department</th>
                <th colspan=2>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${requestScope.employees}" var="employee" >
                <tr>
                    <td><c:out value="${employee.id}" /></td>
                    <td><c:out value="${employee.name}" /></td>
                    <td><c:out value="${employee.mobile}" /></td>
                    <td><c:out value="${employee.dept}" /></td>
                    <td><a href="EmployeeController?action=edit&id=<c:out value="${employee.id}"/>">Update</a></td>
                    <td><a href="EmployeeController?action=delete&id=<c:out value="${employee.id}"/>">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <p><a href="EmployeeController?action=insert">Add Employee</a></p>
</div>
</body>
</html>
