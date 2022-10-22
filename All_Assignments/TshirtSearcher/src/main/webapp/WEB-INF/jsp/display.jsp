<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DISPLAYJSP</title>
<style type="text/css">
th{
background-color: coral;
color:white;
}


</style>
</head>
<body>

<div class="table-user">
<h1>User Records</h1><br><br>
<table border="1" width="100%">

<tr>

<th>UserID</th>
<th>Username</th>

<th>Password</th>
</tr>

<c:forEach var="tab" items="${data}">

<tr>
<td>${tab.id}</td>
<td>${tab.username}</td>
<td>${tab.password}</td>
</tr>

</c:forEach>

</table>
<br>
<h2>${msg}</h2>
</div>

</body>
</html>