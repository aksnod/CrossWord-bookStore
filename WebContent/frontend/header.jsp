<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div align="center">
        <div style="color: blue;height:60px;width:1000px " >
        <div  style="background-color: grey;color: blue;height:60px;width:80px; float:left">
        		<img  src="../images/logo.png " height="60 px" width="80 px" />
        </div>
        
		<div  style="color:white;background-color:olive;  text-align:center;text-shadow:2px 2px 2px black;height:60px;width:920px;font-size:50px; float:right ">
		C <span style="color:red;x">R</span> <span style="color:orange;">O</span> S S W <span style="color:orange; ">O</span> <span style="color:red;x">R</span> D		</div>
		</div>
		</div>
		<br>
		<div align="center">
		<input type="text" name="keyword" size="50" />
		<input type="button" value="Search">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="Login">Sign In</a>
		 <a href="register">Register</a>
		<a href="view_cart">Cart</a>
		</div>
		<div>&nbsp;</div>
		<div align="center">
			<c:forEach var="category" items="${listCategory}" varStatus="status">
			  <a href="view_category?id=${caegory.categoryId}">
				<font size="+1"><b><c:out value="${category.name}"></c:out></b></font>
			   </a>
			   <c:if test="${not status.last }">
			   &nbsp; | &nbsp;
			   </c:if>
			   
			</c:forEach>
		</div>
	</div>
	<style>
a:link{
	color:cornflowerBlue;
	text-decoration: none;
}
a:visited{
color:indigo;
}

a:hover{
	color:blue;
	text-decoration: underline;
}

a:active {
	color:red;
}
</style>