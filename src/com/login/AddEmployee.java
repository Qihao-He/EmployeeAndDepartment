package com.login;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.DepartmentDao;
import com.dao.LoginDao;
import com.elements.Employee;

@WebServlet("/addEmployee")
public class AddEmployee extends HttpServlet {
	private List<Employee> employeeList;
	
	public AddEmployee() {
		employeeList = new ArrayList<>();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String age = request.getParameter("age");
		Employee employee = new Employee(firstName, lastName);
		if (age != null && age.length() != 0) {
			employee.setAge(Integer.parseInt(age));
		}
		employeeList.add(employee);
		HttpSession session = request.getSession();
		session.setAttribute("employeeList", employeeList);
		response.sendRedirect("addEmployee.jsp");
	}
	
//	private void printInConsole(HttpSession session) {
//		System.out.println("HttpSession: " + session.getId());
//		for (Employee e : employeeList) {
//			System.out.println("firstName: " + e.getFirstName() + " lastName: " + e.getLastName() + " age: " + e.getAge());
//		}
//		System.out.println();
//	}
}
