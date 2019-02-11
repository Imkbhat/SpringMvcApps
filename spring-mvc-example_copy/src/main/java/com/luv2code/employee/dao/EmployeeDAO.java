package com.luv2code.employee.dao;

import java.util.List;

import com.luv2code.employee.model.Employee;

public interface EmployeeDAO {
	
	public void addEmployee(Employee employee);
	
	public List<Employee> listEmployee();
	
	public Employee getEmployee(int id);
	
	public void deleteEmployee(Employee employee);

}
