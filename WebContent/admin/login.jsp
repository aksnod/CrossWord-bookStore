<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Login</title>
</head>
<body>
	<div align="center">
		<h1>Book Store Administration</h1>
		<h2>
			Admin Login
		</h2>
		<c:if test="${message !=null}">
			<div align="center" style="color:red; font-style: italic;">
			<h4 class="message" >${message}</h4>
			</div>
		</c:if>
		
		<form action="login" method="post" onsubmit="return validateFromInput()" >
		<table>
		<tr>
			<td>Email:</td>
			<td><input type="Email" name="email" id="email" size="20"></td>
		</tr>
		<tr>
			<td>Password:</td>
			<td><input type="password" name="password" id="password" size="20"></td>
		</tr>
		
		<tr>
			<td colspan="2" align="center"><input type="submit" value="Login" ></td>
		</tr>
		</table>
		</form>
	</div>
	<jsp:directive.include file="footer.jsp"/>
</body>
<script type="text/javascript">
	function validateFromInput(){
		var email=document.getElementById("email");
		var password=document.getElementById("password");
		
		if(email.value.trim()=="" )
		{
			//alert("enter blanck space");
			email.style.border="2px red solid";
			return false;
		}
		else if(password.value.trim()=="" )
		{
			//alert("enter blanck space");
			password.style.border="2px red solid";
			return false;
		}
		
		else
			return true;
	}
</script>
</html>