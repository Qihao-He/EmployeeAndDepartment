package com.dao;


import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import com.mysql.jdbc.Connection;

public class LoginDao {
	private static final String sql = "select * from login where username=? and password=?";
	
	public boolean check(String username, String pass) throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = (Connection) DriverManager.getConnection(Cridentials.getUrl(),
					Cridentials.getSqluser(), Cridentials.getSqlpass());
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, username);
			st.setString(2, pass);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}
}
