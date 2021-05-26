<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manage Category -EverGreen BookStore Administration</title>
</head>
<body>
	<jsp:directive.include file="header.jsp"/>
	<div align="center">
	<h2 align="center">Category Management</h2>
	<h3><a href="category_form.jsp">Create New Category</a></h3>
	</div>
	<c:if test="${message!=null }">
	<div align="center" color="red">
		<h4><i>${message}</i></h4>
	</div>
	</c:if>
	<div align="center">
	<table border="1" cellpadding="5">
	<tr >
	<th>Index</th>
	<th>ID</th>
	<th>Name</th>
	<th>Actions</th>
	</tr>
	<c:forEach var="cat" items="${listCategory}" varStatus="status">
		<tr>
			<td>${status.index+1}</td>
			<td>${cat.categoryId}</td>
			<td>${cat.name}</td>
			<td>
			<a href="edit_category?id=${cat.categoryId}">Edit</a>
			<a href="javascript:confirmDelete(${cat.categoryId})">Delete</a>
			</td>
		</tr>
	</c:forEach>
	</table>
	</div>	
		
		
	<jsp:directive.include file="footer.jsp"/>
	<script>
		function confirmDelete(categoryId){
			if(confirm('Are you sure you want to delete the category with ID '+categoryId+' ?')){
				window.location='delete_category?id='+categoryId;
			}
		}
	</script>
</body>
<style>

</html>