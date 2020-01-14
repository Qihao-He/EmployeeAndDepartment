<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Department</title>
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
	
	<h2>Welcome ${username}</h2>
	<form action="logout"><input type="submit" value="Logout"></form>	
 	<a href="addEmployee.jsp">Add Employee</a><br>
	<a href="welcome.jsp">Welcome page</a><br>
	<a href="videos.jsp">Tutorial Videos</a><br>
	<a href="aboutus.jsp">About us page</a><br>
	
	<h2>Add New Department</h2>
	
 	<form action="addDepartment" method="post">
 		Dept Name: <input type="text" name="name"><br>
 		Dept Email: <input type="text" name="email"><br>
 		<h6>Employee:</h6>
		<c:forEach var="employee" items="${employeeList}">
			<input type="checkbox" name="selected" value="${employee.firstName} ${employee.lastName} ${employee.age}">
			${employee.firstName} ${employee.lastName}<br>
		</c:forEach>
 		<input type="submit" value="submit">
 	</form>
 	
 	<%
		if(session.getAttribute("departmentList") != null) {
			out.println("Existing Department");
		}
	%>
	<br>
	<c:forEach var="department" items="${departmentList}">
		<c:out value="Dept Name: ${department.name} ,"/>
		<c:out value="Email: ${department.email} ,"/>
		<c:out value="Employee: "/>
			<c:forEach var="employee" items="${employeeList}">
				<c:out value="${employee.firstName} ${employee.lastName} ${employee.age} ,"/>
			</c:forEach>
		<c:out value="Employee: ${employee.age}."/><br>
	</c:forEach>
	
</body>
</html>