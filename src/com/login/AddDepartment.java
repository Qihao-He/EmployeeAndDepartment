package com.login;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.DepartmentDao;
import com.dao.LoginDao;

@WebServlet("/addDepartment")
public class AddDepartment extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		DepartmentDao dao = new DepartmentDao();
		try {
			dao.getEmployeesList();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
