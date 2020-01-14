<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add New Employee</title>
</head>
<body>
	<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //HTTP 1.1
		response.setHeader("Pragma", "no-cache"); //HTTP 1.0
		response.setHeader("Expires", "0"); //Proxies
		if(session.getAttribute("username") == null) {
			response.sendRedirect("login.jsp");
		}
	%>
	
	<h2>Welcome  ${username}</h2>
	<form action="logout"><input type="submit" value="Logout"></form>
	
	<a href="welcome.jsp">Welcome page</a><br>
	<a href="addDepartment.jsp">Add Department</a><br>
	<a href="aboutus.jsp">About us page</a><br>
	
	<h2>Add New Employee</h2>
	
 	<form action="addEmployee" method="post">
 		First Name: <input type="text" name="firstName"><br>
 		Last Name: <input type="text" name="lastName"><br>
 		Age: <input type="number" min="0" name="age"><br>
 		<input type="submit" value="submit">
 	</form>
	
	
	<%
		if(session.getAttribute("departmentList") != null) {
			out.println("Existing Employee:");
		}
	%>
	<c:forEach var="employee" items="${employeeList}">
		<c:out value="First Name: ${employee.firstName} ,"/>
		<c:out value="Last Name: ${employee.lastName} ,"/>
		<c:out value="Age: ${employee.age}."/><br>
	</c:forEach>
</body>
</html>