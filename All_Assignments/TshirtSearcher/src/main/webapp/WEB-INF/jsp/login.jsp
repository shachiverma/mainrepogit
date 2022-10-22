<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LOGINJSP</title>
</head>
<body style="background-color: coral;">
<center>

<h1>User Login</h1>

<form:form method="post" action = "signin" modelAttribute="bean">
Enter Username:&emsp;<form:input path="username"/><br><br>
Enter Password:&emsp;<form:input path="password"/><br><br>
			   <input type="submit" value="Login">

</form:form>




</center>

</body>
</html>