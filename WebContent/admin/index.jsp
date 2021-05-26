<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EverGreen BookStore Administration</title>
<link rel="stylesheet" href="../css/style.css"  type="text/css">
</head>
<body>
	<jsp:directive.include file="header.jsp"/>
	<h2 align="center">Administrative DashBoard</h2>
	
	<div align="center" >
		<hr width="60%" />
		<h2>Quick Action</h2>
		<a href="create_book">New Book</a> &nbsp;
		<a href="create_user">New User</a> &nbsp;
		<a href="create_category">New Category</a> &nbsp;
		<a href="create_customer">New Customer</a> &nbsp;
		</div>
		<hr width="60%" />
		
		<div align="center">
		<h2>Recent Sales:</h2>
		</div>
		<hr width="60%" />
		
		<div align="center">
		<h2>Recent Review:</h2>
		</div>
		<hr width="60%" />
		
		<div align="center">
		<h2>Statistics:</h2>
		</div>
		<hr width="60%" />
		
	<jsp:directive.include file="footer.jsp"/>
</body>
</html>


