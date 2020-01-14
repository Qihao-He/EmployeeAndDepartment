package com.model;

import java.util.ArrayList;
import java.util.List;

public class Department {
	private String name;
	private String email;
	private List<String> employeeList;

	public Department(String name, String email) {
		this.name = name;
		this.email = email;
		employeeList = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<String> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<String> employeeList) {
		this.employeeList = employeeList;
	}
	
}
