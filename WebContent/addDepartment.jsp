<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Department page</title>
</head>
<body>
	<h2>Department page</h2><br>	
	<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //HTTP 1.1
		response.setHeader("Pragma", "no-cache"); //HTTP 1.0
		response.setHeader("Expires", "0"); //Proxies
		if(session.getAttribute("username") == null) {
			response.sendRedirect("login.jsp");
		}
	%>
	

	
	<form action="logout"><input type="submit" value="Logout"></form>
	
 	<form action="addDepartment" method="get">
 		Department Name: <input type="text" name="name"><br>
 		Department Email: <input type="text" name="email"><br>
 		<input type="submit" value="add">
 	</form>
 	
 	<a href="addEmployee.jsp">Add Employee</a><br>
	<a href="welcome.jsp">Welcome page</a><br>
	<a href="videos.jsp">Tutorial Videos</a><br>
	<a href="aboutus.jsp">About us page</a><br>
	
</body>
</html>