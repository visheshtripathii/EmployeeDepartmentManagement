package com.employee.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "EMPLOYEE")
public class Employee {
	
	@Id
	//@Column(name="Employee ID")
	private int empId;
	
	//@Column(name="Name")
	private String name;
		
	//@Column(name="Gender")
	private String gender;
	
	//@Column(name="Age")
	private int age;
	
	//@Column(name="Employee Email")
	private String empEmail;
	
	@Column(length = 1000)
	//@Column(name="Employee Description")
	private String jobDepartment;
	
	//@Column(name="Employee Salary")
	private String salary;
	
	//@Column(name="Employee Qualification")
	private String qualification;
		
	@ManyToOne
	@JsonBackReference
	private Manager manager;

	
	//GETTERS AND SETTERS
	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public String getJobDepartment() {
		return jobDepartment;
	}

	public void setJobDepartment(String jobDepartment) {
		this.jobDepartment = jobDepartment;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	//CONSTRUCTOR
	public Employee(int empId, String name, String gender, int age, String empEmail, String jobDepartment,
			String salary, String qualification, Manager manager) {
		super();
		this.empId = empId;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.empEmail = empEmail;
		this.jobDepartment = jobDepartment;
		this.salary = salary;
		this.qualification = qualification;
		this.manager = manager;
	}

	//DEFAULT CONSTRUCTOR
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	//TO STRING
	@Override
	public String toString() {
		return "Employee [empId=" + empId + "]";
	}
	
	
	
	
	
	

	
}
