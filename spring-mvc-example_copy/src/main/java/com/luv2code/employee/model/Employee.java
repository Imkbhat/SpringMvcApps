package com.luv2code.employee.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	
	
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 @Column(name="emp_id")
	 private Integer emp_id;

	 @Column(name="emp_name")
	 private String emp_name;
	 
	 @Column(name="emp_age")
	 private Integer emp_age;
	 
	 @Column(name="salary")
	 private Integer salary;
	 
	 @Column(name="address")
	 private String address;
	 
	 public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(Integer emp_id, String emp_name, Integer emp_age, Integer salary, String address) {
		this.emp_name = emp_name;
		this.emp_age = emp_age;
		this.salary = salary;
		this.address = address;
	}
	
	public Integer getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(Integer emp_id) {
		this.emp_id = emp_id;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public Integer getEmp_age() {
		return emp_age;
	}

	public void setEmp_age(Integer emp_age) {
		this.emp_age = emp_age;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", emp_name=" + emp_name + ", emp_age=" + emp_age + ", salary=" + salary
				+ ", address=" + address + "]";
	}
}
