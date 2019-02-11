package com.luv2code.spring.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.spring.entity.Employee;
import com.luv2code.spring.model.User;
import com.luv2code.spring.service.EmployeeService;

@Controller
public class HomeController {
	
	@Autowired
	private EmployeeService empService;
	
	@RequestMapping("/")
	public String showHome(Model model, Locale locale) {
		System.out.println("Home Page Requested, locale = " + locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate);
		return "home";
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public String user(@Validated User user, Model model) {
		System.out.println("User Page Requested");
		model.addAttribute("userName", user.getUserName());
		return "user";
	}
	
	@RequestMapping(value="/employee", method=RequestMethod.GET)
	public String addEmployee(Model model) {
		model.addAttribute("employee", new Employee());
		return "addEmployee";
	}
	
	@RequestMapping(value="/saveEmployee", method = RequestMethod.POST)
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		empService.addEmployee(employee);
		return "redirect:/listEmployee";
	}
	
	@RequestMapping(value="/listEmployee" ,method=RequestMethod.GET)
	public String listEmployee(Model model) {
		List<Employee>  empList = empService.listEmployee();
		model.addAttribute("empList", empList);
		return "listEmployee";
	}
	
	@RequestMapping(value="/edit", method=RequestMethod.GET)
	public String editEmployee(@RequestParam("empId") int theId, Model model) {
		Employee employee = empService.getEmployee(theId);
		model.addAttribute("employee", employee);
		return "addEmployee";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String deleteEmployee(@RequestParam("empId") int theId, Model model) {
		empService.deleteEmployee(theId);
		return "redirect:/listEmployee";
	}
}
