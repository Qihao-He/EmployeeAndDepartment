package com.dao;

public class Cridentials {
	private static final String url = "jdbc:mysql://localhost:3306/sales";
	private static final String sqluser = "root";
	private static final String sqlpass = "qihaohe";
	static String getUrl() {
		return url;
	}
	static String getSqluser() {
		return sqluser;
	}
	static String getSqlpass() {
		return sqlpass;
	}
}
