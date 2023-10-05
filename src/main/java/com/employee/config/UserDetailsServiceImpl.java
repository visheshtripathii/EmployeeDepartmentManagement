//package com.employee.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//import com.employee.dao.ManagerRepository;
//import com.employee.entities.Manager;
//
//public class UserDetailsServiceImpl implements UserDetailsService {
//
//	@Autowired
//	private ManagerRepository managerRepository;
//	
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		
//		//fetching user from database
//		
//		Manager manager = managerRepository.getManagerByUserName(username);
//		
//		if(manager==null) {
//			throw new UsernameNotFoundException("Could not find user !!");
//		}
//		
//		CustomUserDetails customUserDetails=new CustomUserDetails(manager);
//		
//		return customUserDetails;
//	}
//
//}
