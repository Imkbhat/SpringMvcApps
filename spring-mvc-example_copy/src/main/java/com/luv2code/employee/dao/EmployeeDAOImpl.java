package com.luv2code.employee.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.employee.model.Employee;

@Repository("employeeDAO")
public class EmployeeDAOImpl implements EmployeeDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void addEmployee(Employee employee) {
		sessionFactory.getCurrentSession().saveOrUpdate(employee);
	}

	@Override
	public List<Employee> listEmployee() {
		List<Employee> employeeList = 
				(List<Employee>) sessionFactory.getCurrentSession().createQuery("SELECT * FROM Employee", Employee.class);
		return employeeList;
	}

	@Override
	public Employee getEmployee(int id) {
		return (Employee)sessionFactory.getCurrentSession().get(Employee.class, id);
	}

	@Override
	public void deleteEmployee(Employee employee) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM Employee WHERE emp_id="+employee.getEmp_id()).executeUpdate();
	}

}
