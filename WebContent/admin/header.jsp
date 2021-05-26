<link rel="stylesheet" href="../css/style.css"  type="text/css">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div align="center">
        <div style="color: blue;height:60px;width:1000px " >
        <div  style="background-color: grey;color: blue;height:60px;width:80px; float:left">
        		<img  src="../images/logo.png " height="60 px" width="80 px" />
        </div>
        
		<div  style="color:white;background-color:olive;  text-align:center;text-shadow:2px 2px 2px black;height:60px;width:920px;font-size:50px; float:right ">
		C <span style="color:red;x">R</span> <span style="color:orange;">O</span> S S W <span style="color:orange; ">O</span> <span style="color:red;x">R</span> D		</div>
		</div>
		<br>
		<div>
		Welcome <c:out value="${sessionScope.useremail}" 
		/> | <a href="logout">Logout</a>
		</div>
		<br/>
		<div style=" display: table">
		<div style="display: table-cell"><a href="list_users">
			<img  src="../images/user.png" style="height:30px;width:30px">Users
		</a> </div>&nbsp;&nbsp;&nbsp;
		
		<div style="display: table-cell "><a href="list_category">
			<img  src="../images/category.png" style="height:30px;width:30px;">
		Categories</a></div>&nbsp;&nbsp;&nbsp;
		
		 <div style="display: table-cell;">
		 	<a href="list_books"><img  src="../images/books.jpg" style="height:30px;width:30px;">Books</a> 
		 </div>&nbsp;&nbsp;&nbsp;
		 
		 <div style="display: table-cell">
		 		<a href="customer"><img  src="../images/customer.jpg" style="height:30px;width:30px;">Customers</a> 
		 </div>&nbsp;&nbsp;&nbsp;
		 
		 <div style="display: table-cell">	
		 	<a href="reviews"><img  src="../images/reviews.png"style="height:30px;width:30px;">Reviews</a> 
		 </div>&nbsp;&nbsp;&nbsp;
		 
		 <div style="display: table-cell">		
		 	<a href="orders"><img  src="../images/order.png" style="height:30px;width:30px;">Orders</a> 
		 </div>&nbsp;&nbsp;&nbsp;
		
		</div>
		
		
</div>
<style>
a:link{
	color:maroon;
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
th{
background-color:aqua;

}

table{
font-size:16px;
padding: 10px;
border-radius: 20px;
margin:30px;



}
td{
padding-right: 20px;
}

input{
border-color: lime;
border-radius: 4px;
padding-left: 3px;
}
input[type=submit]{
border-radius: 0px,10px,0px,10px;
border-color: red;
margin-right: 20px;
}
h2{
color:blue;
font-size: 20px;
font-family: serif;
}
h3{
font-size: 20px;
font-family: serif;
}
</style>