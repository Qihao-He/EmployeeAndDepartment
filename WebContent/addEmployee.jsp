<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Employee page</title>
</head>
<body>
	<h2>Add Employee page</h2><br>
	
	<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //HTTP 1.1
		response.setHeader("Pragma", "no-cache"); //HTTP 1.0
		response.setHeader("Expires", "0"); //Proxies
		if(session.getAttribute("username") == null) {
			response.sendRedirect("login.jsp");
		}
	%>
	
 	<form action="addEmployee" method="post">
 		FirstName: <input type="text" name="firstName"><br>
 		LastName: <input type="text" name="lastName"><br>
 		Age: <input type="number" min="0" name="age"><br>
 		<input type="submit" value="add">
 	</form>
 	
	<a href="welcome.jsp">Welcome page</a><br>
	<a href="aboutus.jsp">About us page</a><br>
	<form action="logout"><input type="submit" value="Logout"></form>
	
	<c:forEach var="employee" items="${employeeList}">
		<c:out value="Firstname: ${employee.firstName} ,"/>
		<c:out value="Lastname: ${employee.lastName} ,"/>
		<c:out value="Age: ${employee.age}."/><br>
	</c:forEach>
</body>
</html>