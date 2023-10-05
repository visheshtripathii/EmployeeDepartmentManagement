package com.employee.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee.dao.ManagerRepository;
import com.employee.entities.Employee;
import com.employee.entities.Manager;
import com.employee.helper.Message;
import com.employee.service.EmployeeService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;


@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getEmployees(){
		
		List<Employee> list= this.employeeService.getAllEmployees();
		
		if(list.size()<=0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		return ResponseEntity.status(HttpStatus.CREATED).body(list);
	} 
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable("id") int id){
		
		Employee employee= this.employeeService.getEmployeeById(id);
		
		if(employee==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(employee);
		
	}
	
	@PostMapping("/employees")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
				
		try {
			
			this.employeeService.addEmployee(employee);
			System.out.println(employee);
			return ResponseEntity.status(HttpStatus.OK).body(employee) ;
			
		} catch (Exception e) {
			
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			  
		}
		
	}

	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable("id") int id){
		
		try {
			
			this.employeeService.deleteEmployee(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			
		}

	}
	
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable("id") int empId){
		
		try {
			
			System.out.println(empId);
			this.employeeService.updateEmployee(employee, empId);
			return ResponseEntity.ok().body(employee);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			
		}
		
	}
	


}
