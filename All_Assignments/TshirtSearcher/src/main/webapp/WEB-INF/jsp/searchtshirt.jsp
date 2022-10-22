<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib uri="http://www.springframework.org/tags/form" prefix ="form" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
    <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SerachT-shirtJSP</title>
</head>
<body style="background-color: coral;">
<center>

<h1>Search Tshirts</h1>
<form:form action ="searchtshirt" method ="post" modelAttribute="bean">
	Enter Color: <form:input path="tshirt_colour"/>&nbsp;
	and Enter Gender: <form:input path="gender_choice"/>&nbsp;
	and Enter Size: <form:input path="size_choice"/>
	
	<br>
	<br>
	
	<input type="submit" value="Search">



</form:form>
<br>
<br>
<table border="1" width="100%">
<tr>
<th>Tshirt_Id</th>
<th>Tshirt_Name</th>
<th>Tshirt_Color</th>
<th>Gender</th>
<th>Size</th>
<th>Price</th>
<th>Rating</th>
<th>Availability</th>

</tr>

<c:forEach var="tab" items="${li}">
<tr>
<td>${tab.tshirt_id}</td>
<td>${tab.tshirt_name}</td>
<td>${tab.tshirt_colour}</td>
<td>${tab.gender_choice}</td>
<td>${tab.size_choice}</td>
<td>${tab.tshirt_price}</td>
<td>${tab.tshirt_rating}</td>
<td>${tab.tshirt_available}</td>
</tr>
</c:forEach>


</table>


<h2>${msg}</h2>


</center>



</body>
</html>