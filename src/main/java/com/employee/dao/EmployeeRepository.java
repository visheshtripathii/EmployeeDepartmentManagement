package com.employee.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.employee.entities.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer>{

	public Employee findById(int id);
	
}
