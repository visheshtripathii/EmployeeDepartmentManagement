package com.employee.dao;


import org.springframework.data.jpa.repository.JpaRepository;


import com.employee.entities.Manager;

public interface ManagerRepository extends JpaRepository<Manager, Integer> {
	
}
