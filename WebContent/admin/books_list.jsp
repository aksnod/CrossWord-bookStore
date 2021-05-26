<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manage Books -CROSSWORD Administration</title>
</head>
<body>
	<jsp:directive.include file="header.jsp"/>
	<div align="center">
	<h2 align="center">Book Management</h2>
	<h3><a href="new_book">Create New Book</a></h3>
	</div>
	<c:if test="${message!=null }">
	<div align="center" color="red">
		<h4><i>${message}</i></h4>
	</div>
	</c:if>
	<div align="center">
	<table border="1" cellpadding="5">
	<tr>
	<th>Index</th>
	<th>ID</th>
	<th>Image</th>
	<th>Title</th>
	<th>Authors</th>
	<th>Category</th>
	<th>Price</th>
	<th>Last Updated</th>
	<th>Actions</th>
	</tr>
	<c:forEach var="book" items="${listBook}" varStatus="status">
		<tr>
			<td>${status.index+1}</td>
			<td>${book.bookId}</td>
			<td>
				<img src="data:image/jpg;base64,${book.base64Image}" width="84px" height="110px">
			</td>
			<td>${book.title}</td>
			 <td>${book.author}</td>
			<td>${book.category.name}</td>
			<td>${book. price}</td>
			<td>${book.lastUpdatedOn}</td>
			
			<td>
			<a href="edit_book?id=${author}">Edit</a> 
			<a href="javascript:confirmDelete(${author})">Delete</a>
			</td>
		</tr>
	</c:forEach>
	</table>
	</div>	
		
		
	<jsp:directive.include file="footer.jsp"/>
	<script>
		function confirmDelete(userId){
			if(confirm('Are you sure you want to delete the user with ID '+userId+' ?')){
				window.location='delete_user?id='+userId;
			}
		}
	</script>
</body>
</html>


