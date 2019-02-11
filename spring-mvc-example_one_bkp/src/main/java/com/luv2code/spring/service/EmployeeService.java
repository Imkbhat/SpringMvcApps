package com.luv2code.spring.service;

import java.util.List;

import com.luv2code.spring.entity.Employee;


public interface EmployeeService {
	
	public void addEmployee(Employee employee);
	
	public List<Employee> listEmployee();
}
