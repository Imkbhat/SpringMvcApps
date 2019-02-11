package com.luv2code.spring.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.spring.entity.Employee;


@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addEmployee(Employee employee) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(employee);
	}

	@Override
	public List<Employee> listEmployee() {
		Session session = sessionFactory.getCurrentSession();
		
		Query<Employee>  query = 
				session.createQuery(" from Employee order by lastName ", Employee.class);
		
		//execute and get result list
		
		List<Employee> empList =  query.getResultList();
		return empList;
	}

	@Override
	@Transactional
	public Employee getEmployee(int id) {
		Session session = sessionFactory.getCurrentSession();
		Employee employee = session.get(Employee.class, id);
		return employee;
	}

	@Override
	@Transactional
	public void deleteEmployee(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete FROM Employee WHERE id=:empId");
		query.setParameter("empId", id);
		query.executeUpdate();
	}

}
