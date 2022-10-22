<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix = "form" %>
    <%@page isELIgnored = "false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RegisterJSP</title>
<style type="text/css">
h2{
color:red;
}
.register-form{
margin-top:50px;
margin-left:500px;

}

</style>
</head>
<body style="background-color: coral;">

<div class="register-form">
	<h1>Register Page</h1>
	<form:form action="store" method="post" modelAttribute ="bean">
	
	Enter UserId:&nbsp;&nbsp;&nbsp;&nbsp;<form:input path="username"/> <br><br/>
	Enter Password:<form:input path = "password"/> <br><br/>
	
	<input type="submit" value = "Register">
	
	</form:form>
	
	<br/>
	<h2>${msg}</h2>
	
</div>

</body>
</html>