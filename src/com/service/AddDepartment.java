package com.service;

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
import com.model.Employee;
import com.model.Department;

@WebServlet("/addDepartment")
public class AddDepartment extends HttpServlet {
	List<Department> departmentList;
	
	public AddDepartment() {
		departmentList = new ArrayList<>();
	}
	
	@SuppressWarnings("null")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String[] selectedEmployees = request.getParameterValues("selected");
		
		Department department = new Department(name, email);
		departmentList.add(department);
		
		if (selectedEmployees == null || selectedEmployees.length == 0) {
			response.sendRedirect("addDepartment.jsp");
		} else { 
			List<String> employeeList = department.getEmployeeList();
			for (String e : selectedEmployees) {
				employeeList.add(e);
			}
			request.setAttribute("hasDepartments", true);		
			request.getRequestDispatcher("addDepartment.jsp").forward(request, response);
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("departmentList", departmentList);
		printInConsole(session);
	}

	private void printInConsole(HttpSession session) {
		System.out.println("HttpSession: " + session.getId());
		for (Department d : departmentList) {
			System.out.println("department name: " + d.getName() + ", department email: " + d.getEmail());
			List<String> employeeList =  d.getEmployeeList();
			for (String e : employeeList) {
				System.out.println("employee name: " + e + ",");
			}
		}
		System.out.println();
	}
}
