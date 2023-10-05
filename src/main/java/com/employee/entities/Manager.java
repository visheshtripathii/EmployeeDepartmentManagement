package com.employee.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "MANAGER")
public class Manager {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@NotBlank(message = "Name is required!")
	@Size(min = 2,max = 20,message = "Name should be of 2-20 chars!")
	private String name;
	
	@Column(unique = true)
	private String email;
	
	private String password;
	
	private String imageUrl;
	
	@Column(length = 500)
	private String about;
	
	private String role;
	
	private boolean enabled;
	
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, mappedBy = "manager")
	@JsonManagedReference
	private List<Employee> employees= new ArrayList<>();


	//GETTERS AND SETTERS
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	//CONSTRUCTOR USING FIELDS
	public Manager(int id, String name, String email, String password, String imageUrl, String about, String role,
			boolean enabled) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.imageUrl = imageUrl;
		this.about = about;
		this.role = role;
		this.enabled = enabled;
	}

	//DEFAULT CONSTRUCTOR
	public Manager() {

	}

	// TO STRING 
	@Override
	public String toString() {
		return "Manager [id=" + id + "]";
	}
	
	
	
	
	
}
