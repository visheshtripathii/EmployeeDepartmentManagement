package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.employee.entities.Employee;
import com.employee.helper.Message;
import com.employee.service.EmployeeService;

import jakarta.servlet.http.HttpSession;

@Controller
public class ManagerController {
	
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/emp-dashboard")
	public String dashboard(Model model) {
		
		List<Employee> emp= this.employeeService.getAllEmployees();
		model.addAttribute("emp",emp);
		
		model.addAttribute("title", "Dashboard - Employee Department Management Module");
		return "emp-dashboard";
	}
	
	@GetMapping("/add-emp")
	public String addEmpForm(Model model) {
		model.addAttribute("title", "Employee form - Employee Department Management Module");
		return "add-emp";
	}
	
	@PostMapping("/register")
	public String empRegister(@ModelAttribute("e") Employee e,HttpSession session) {
		System.out.println(e);
		employeeService.addEmployee(e);
		session.setAttribute("message", new Message("Sucessfully registered !!","alert-success"));
		
		System.out.println("Success!!");
		System.out.println(e);
		return "redirect:/emp-dashboard";	
	}
	
	@GetMapping("/edit/{empId}")
	public String edit(@PathVariable int empId,Model model) {
		
		Employee e= employeeService.getEmployeeById(empId);
		
		model.addAttribute("emp", e);
		
		return "edit";
	}
	
	@PostMapping("/update")
	public String updateEmp(@ModelAttribute Employee e,HttpSession session) {
		
		employeeService.addEmployee(e);
		session.setAttribute("message", new Message("Sucessfully Updated !!","alert-success"));
		
		System.out.println("Updated!!");
		return "redirect:/emp-dashboard";
	}
	
	@GetMapping("/delete/{empId}")
	public String deleteEmp(@PathVariable int empId,HttpSession session) {
		
		employeeService.deleteEmployee(empId);
		session.setAttribute("message", new Message("Sucessfully deleted !!","alert-success"));
		
		return "redirect:/emp-dashboard";
	}
	
}
