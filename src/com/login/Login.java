package com.login;


import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.LoginDao;

@WebServlet("/login")
public class Login extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		LoginDao dao = new LoginDao();
		try {
			if (dao.check(username, password)) {
				HttpSession session = request.getSession();
				session.setAttribute("username", username);
				response.sendRedirect("welcome.jsp");
			} else {
				request.setAttribute("invalid", true);		
				request.getRequestDispatcher("login.jsp").forward(request, response);
//				response.sendRedirect("login.jsp");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
