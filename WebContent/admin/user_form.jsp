<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create New User</title>
</head>
<body>
<jsp:directive.include file="header.jsp"/>
	<h2 align="center">Administrative DashBoard</h2>
	
	<div align="center" >
	<h3>
		<c:if test="${user!=null}">
			Edit User
		</c:if>
		
		<c:if test="${user==null}">
	    Create New User
	    </c:if>
	
	</h3>
	</div>
	<div align="center">
	<c:if test="${user!=null}">
		<form action="update_user" method="post" onsubmit="return validateFromInput()">
		<input type="hidden" name="userId" value="${user.userId}">
	 </c:if>
	
	<c:if test="${user==null}">
			<form action="create_user" method="post" onsubmit="return validateFromInput()">
	 </c:if>
	<table>
	<tr>
		<td>Email:</td>
		<td><input type="email" id="email" name="email" size="20" value="${user.email }"></td>
	</tr>
	<tr>
		<td>Full Name:</td>
		<td><input type="text" id="fullName" name="fullname" size="20" value="${user.fullName }"></td>
	</tr>
	<tr>
		<td>Password:</td>
		<td><input type="password" id="password" name="password" size="20" value="${user.password }"></td>
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
<script type="text/javascript">
	function validateFromInput(){
		var email=document.getElementById("email");
		var usrname=document.getElementById("fullName");
		var password=document.getElementById("password");
		if(email.value.trim()=="" )
		{
			//alert("enter blanck space");
			email.style.border="2px red solid";
			return false;
		}
		if(usrname.value.trim()=="" )
		{
			//alert("enter blanck space");
			usrname.style.border="2px red solid";
			return false;
		}
		else if(password.value.trim()=="")
		{
			password.style.border="2px red solid";
			return false;
		}
		else if(password.value.trim().length<5)
			{
				document.getElementById("passlbl").style.visibility="visible";
				return false;
			}
		else
			return true;
	}

</script>
</html>