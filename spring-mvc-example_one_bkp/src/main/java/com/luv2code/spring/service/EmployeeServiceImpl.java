package com.luv2code.spring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.spring.dao.EmployeeDAO;
import com.luv2code.spring.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDAO empDAO;

	@Override
	@Transactional
	public void addEmployee(Employee employee) {
		empDAO.addEmployee(employee);
	}

	@Override
	@Transactional
	public List<Employee> listEmployee() {
		return empDAO.listEmployee();
	}

}
