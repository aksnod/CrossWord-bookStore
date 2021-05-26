<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create New Category</title>
<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
<script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
</head>
<body>
<jsp:directive.include file="header.jsp"/>
	<h2 align="center">Administrative DashBoard</h2>
	
	<div align="center" >
	<h3>
		<c:if test="${category!=null}">
			Edit Category
		</c:if>
		
		<c:if test="${category==null}">
	    Create New Category
	    </c:if>
	
	</h3>
	</div>
	<div align="center">
	<c:if test="${category!=null}">
		<form action="update_category" method="post" id="categoryform">
		<input type="hidden" name="categoryId" value="${category.categoryId}">
	 </c:if>
	
	<c:if test="${category==null}">
			<form action="create_category" method="post"  id="categoryform">
	 </c:if>
	<table>

	<tr>
		<td>Name:</td>
		<td><input type="text" id="name" name="name" size="20" value="${category.name }"></td>
	</tr>
	
	<tr><td>&nbsp;</td></tr>
	<tr>
		<td colspan="2" align="center">
		<input type="submit" value="Save" >
		<input type="button" value="Cancel" onclick="javascript:history.go(-1);" >
		</td>
	</tr>
	</table>
	</form>
	</div>
		
		
	<jsp:directive.include file="footer.jsp"/>
</body>
<!--  <script type="text/javascript">
	function validateFromInput(){
		var categoryname=document.getElementById("name");
		
		if(categoryname.value.trim()=="" )
		{
			//alert("enter blanck space");
			categoryname.style.border="2px red solid";
			return false;
		}
		
		else
			return true;
	}
</script>-->
<script>
$(document).ready(function(){
	   $("#categoryform").click(function(){
	        if ($('#name').val() == ""){
	            alert('Please complete the field');
	            $("#name").focus();
	            return false;
	        }
	    });
	});


</script>
</html>

