<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login page</title>
</head>
<body>
 	<%
		if(request.getAttribute("invalid") != null) {
			out.println("invalid username or password");
		}
	%>
	<h2>Login page</h2>
 	<form action="login" method="post">
 		Enter username: <input type="text" name="username"><br>
 		Enter password: <input type="password" name="password"><br>
 		<input type="submit" value="login">
 	</form>
 	<a href="aboutus.jsp">About us page</a>
</body>
</html>