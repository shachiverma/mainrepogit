<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix ="form" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
    <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SEARCHJSP</title>
</head>
<body style="background-color: coral;">
<center>

<h1>Search User Record</h1>
<form:form action ="search" method ="post" modelAttribute="bean">
	Enter UserID: <form:input path="id"/>&nbsp;
	or Username: <form:input path="username"/>&nbsp;
	or Password: <form:input path="password"/>
	<br>
	<br>
	
	<input type="submit" value="Search">



</form:form>
<br>
<br>
<table border="1" width="100%">
<tr>
<th>UserId</th>
<th>Username</th>
<th>Password</th>
</tr>

<c:forEach var="tab" items="${li}">
<tr>
<td>${tab.id}</td>
<td>${tab.username}</td>
<td>${tab.password}</td>
</tr>
</c:forEach>


</table>


<h2>${msg}</h2>


</center>



</body>
</html>