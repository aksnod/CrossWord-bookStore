<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create New Book</title>

<link rel="stylesheet" href="../css/jquery-ui.min.css">

<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
<script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="../js/jquery-ui.min.js"></script>
</head>
<body>
<jsp:directive.include file="header.jsp"/>
	<h2 align="center">Administrative DashBoard</h2>
	
	<div align="center" >
	<h3>
		<c:if test="${book!=null}">
			Edit Book
		</c:if>
		
		<c:if test="${book==null}">
	    Create New Book
	    </c:if>
	
	</h3>
	</div>
	<div align="center">
	<c:if test="${book!=null}">
		<form action="update_book" method="post"  >
		
	 </c:if>
	
	<c:if test="${book==null}">
			<form action="create_book" method="post" enctype="multipart/form-data">
	 </c:if>
	<table style="margin-right:200px">
	<tr>
	<td>Category</td>
	<td>
	<select name="category" >
		<c:forEach items="${listCategory}" var="category">
			<option value="${category.categoryId}">
			${category.name}
			</option>
		</c:forEach>
	</select>
	</td>
	</tr>
	<tr>
		<td>Title:</td>
		<td><input type="text" id="title" name="title" size="20" value="${book.title }"></td>
	</tr>
	<tr>
		<td>Author:</td>
		<td><input type="text" id="author" name="author" size="20" value="${book.author}"></td>
	</tr>
	<tr>
		<td>ISBN:</td>
		<td><input type="text" id="isbn" name="isbn" size="20" value="${book.isbn }"></td>
	</tr>
	<tr>
		<td>Publish Date:</td>
		<td><input type="text" id="publishDate" name="publishDate" size="20" value="${book.publishDate}"></td>
	</tr>
	<tr>
		<td>Book Image:</td>
		<td><input type="file" id="bookImage" name="bookImage" size="20" value="${book.bookImage}">
		<img id="thumbnail" alt="Image Preview" style="width:10%; margin-top:20px"/></td>
	</tr>
	<tr>
		<td>Price:</td>
		<td><input type="text" id="price" name="price" size="20" value="${book.price}"></td>
	</tr>
	<tr>
		<td>Description:</td>
		<td>
		<textarea rows="5" cols="15" name="description" id="description"></textarea>
		</td>
	</tr>
	<tr><td>&nbsp;</td></tr>
	<tr>
		<td colspan="2" align="center">
		<input type="submit" value="Save" id="bookform">
		<input type="button" value="Cancel" onclick="javascript:history.go(-1);" >
		</td>
	</tr>
	</table>
	</form>
	</div>
		
		
	<jsp:directive.include file="footer.jsp"/>
</body>

<script>
$(document).ready(function(){

    $( "#publishDate" ).datepicker();
  
  	$('#bookImage').change(function(){
  		showImageThumbnail(this);
  	});
  	
  	$("#bookform").click(function(){
  		if ($('#category').val() == "" || $('#title').val() == "" || $('#author').val() == "" || $('#isbn').val() == "" || $ ('#publishDate').val() == "" || $('#bookImage').val() == "" || $('#price').val() == "" || $('#description').val() == "" ){
            alert('Please complete the field');
            return false;
        }
  	
  	});
});
 function showImageThumbnail(fileInput){
	  var file=fileInput.files[0];
	  
	  var reader=new FileReader();
	  reader.onload=function(e){
		  $('#thumbnail').attr('src', e.target.result);
	  };
	  reader.readAsDataURL(file);
  }
  
</script>
</html>