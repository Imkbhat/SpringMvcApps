package com.luv2code.employee.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.luv2code.employee.bean.EmployeeBean;
import com.luv2code.employee.model.Employee;
import com.luv2code.employee.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String welcome() {
		return "index";
	}
	
	@RequestMapping(value="/employees", method=RequestMethod.GET)
	public String listEmployee(Model model) {
		model.addAttribute("employees", empService.listEmployee());
		return "listEmployee";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	 public ModelAndView addEmployee(@ModelAttribute("command")EmployeeBean employeeBean,
	   BindingResult result) {
	  Map<String, Object> model = new HashMap<String, Object>();
	  model.put("employees",  prepareListofBean(empService.listEmployee()));
	  return new ModelAndView("addEmployee", model);
	 }
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveEmployee(@ModelAttribute("command") EmployeeBean empBean, BindingResult result) {
		
		  Employee employee = prepareModel(empBean);
		  empService.addEmployee(employee);
		  
		  Map<String, Object> model = new HashMap<String, Object>();
		  model.put("employees",  prepareListofBean(empService.listEmployee()));
		return new ModelAndView("listEmployee", model);
	}
	

	 private Employee prepareModel(EmployeeBean employeeBean){
	  Employee employee = new Employee();
	  employee.setAddress(employeeBean.getAddress());
	  employee.setEmp_age(employeeBean.getAge());
	  employee.setEmp_name(employeeBean.getName());
	  employee.setSalary(employeeBean.getSalary());
	  return employee;
	 }
	 
	 private List<EmployeeBean> prepareListofBean(List<Employee> employees){
	  List<EmployeeBean> beans = null;
	  if(employees != null && !employees.isEmpty()){
	   beans = new ArrayList<EmployeeBean>();
	   EmployeeBean bean = null;
	   for(Employee employee : employees){
	    bean = new EmployeeBean();
	    bean.setName(employee.getEmp_name());
	    bean.setId(employee.getEmp_id());
	    bean.setAddress(employee.getAddress());
	    bean.setSalary(employee.getSalary());
	    bean.setAge(employee.getEmp_age());
	    beans.add(bean);
	   }
	  }
	  return beans;
	 }
	 
	 private EmployeeBean prepareEmployeeBean(Employee employee){
	  EmployeeBean bean = new EmployeeBean();
	  bean.setAddress(employee.getAddress());
	  bean.setAge(employee.getEmp_age());
	  bean.setName(employee.getEmp_name());
	  bean.setSalary(employee.getSalary());
	  bean.setId(employee.getEmp_id());
	  return bean;
	 }
}
