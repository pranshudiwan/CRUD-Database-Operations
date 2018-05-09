<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="description" content="Search the database">
<meta name="author" content="Pranshu Diwan">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="stylesheet" type="text/css" href="style.css">

<title>Upload Database</title>

</head>
<body>
<br>
	<nav class="main-nav">
       
      <a href="index.jsp">Import</a>
      <a href="main.jsp">Search / Update / Delete</a>
      <a href="EmployeeController?action=insert">Insert</a>
      <a href='EmployeeController?action=listEmployees'>List of Employees</a>
    
    </nav>
    
<br><br><br>

<h2>Hexaware Technologies Ltd.</h2><br>

	<div class="box1">
		<form action="UploadDatabase" method="post" enctype="multipart/form-data">
			<h3 style = "font-family: sans-serif;">Select file to upload: </h3>
			<input type="file" name="file" size="60" /><br>
			<br> <input type="submit" value="Import database">
		</form>
	</div>
 
</body>
</html>
