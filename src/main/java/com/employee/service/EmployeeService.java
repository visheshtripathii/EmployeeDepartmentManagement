package com.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.dao.EmployeeRepository;
import com.employee.entities.Employee;


@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	// GET ALL EMPLOYEES
	public List<Employee> getAllEmployees() {

		List<Employee> list = (List<Employee>) this.employeeRepository.findAll();
		return list;
		
	}

	// GET EMPLOYEE BY ID
	public Employee getEmployeeById(int id) {

		Employee employee = null;

		try {

			employee = this.employeeRepository.findById(id);

		} catch (Exception e) {

			System.out.println("No data found, check the employee ID again :)");
			e.printStackTrace();

		}

		return employee;
	}
	
	// ADD AN EMPLOYEE 
	public Employee addEmployee(Employee emp) {
		
		Employee result = this.employeeRepository.save(emp);
		return result;
		
	}
	
	// DELETE AN EMPLOYEE BY ID
	public void deleteEmployee(int empId) {
	
		this.employeeRepository.deleteById(empId);
		
	}
	
	// UPDATE AN EMPLOYEE BY ID
	public void updateEmployee(Employee employee,int empId) {
		
		employee.setEmpId(empId);
		this.employeeRepository.save(employee);
		
	}
	

}
