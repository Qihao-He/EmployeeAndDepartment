package com.dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

public class EmployeeDao {
	
	private static final String sql = "select * from employees";
	
	public List<String> getEmployeesList() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = (Connection) DriverManager.getConnection(Cridentials.getUrl(), 
				Cridentials.getSqluser(), Cridentials.getSqlpass());
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		List<String> employeesList = new ArrayList<>(); 
		while (rs.next()) {
			
			String tempName = new StringBuilder("id: "  + rs.getInt("id") +  " " +
			rs.getString("lastname") + " " + rs.getString("firstname")).toString();
			
			System.out.println("employee: " + tempName);
			employeesList.add(tempName);
		}
		return employeesList;
	}
	
	public void addEmployee() {
	}
}
