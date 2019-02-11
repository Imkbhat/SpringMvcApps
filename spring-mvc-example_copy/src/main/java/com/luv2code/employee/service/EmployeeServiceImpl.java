package com.luv2code.employee.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.luv2code.employee.dao.EmployeeDAO;
import com.luv2code.employee.model.Employee;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDAO empDao;
	
	@Override
	@Transactional
	public void addEmployee(Employee employee) {
		empDao.addEmployee(employee);
	}

	@Override
	@Transactional
	public List<Employee> listEmployee() {
		return empDao.listEmployee();
	}

	@Override
	@Transactional
	public Employee getEmployee(int id) {
		// TODO Auto-generated method stub
		return empDao.getEmployee(id);
	}

	@Override
	@Transactional
	public void deleteEmployee(Employee employee) {
		empDao.deleteEmployee(employee);
	}

}
