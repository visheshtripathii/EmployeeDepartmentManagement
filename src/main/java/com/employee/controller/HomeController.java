package com.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.employee.dao.ManagerRepository;
import com.employee.entities.Manager;
import com.employee.helper.Message;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class HomeController {
	
	@Autowired
	private ManagerRepository managerRepository;

	@RequestMapping("/")
	public String home(Model model ) {
		model.addAttribute("title", "Home - Employee Department Management Module");
		return "home";
	}
	
	@RequestMapping("/about")
	public String about(Model model ) {
		model.addAttribute("title", "About - Employee Department Management Module");
		return "about";
	}
	
	@RequestMapping("/signup")
	public String signup(Model model ) {
		model.addAttribute("title", "Register - Employee Department Management Module");
		model.addAttribute("manager", new Manager());
		return "signup";
	}
	 
	//handler for registering manager
	@PostMapping("/do_register")
	public String registerManager(@Valid
			                      @ModelAttribute("manager") Manager manager, BindingResult result1,
			                      @RequestParam(value = "agreement",defaultValue = "false")
	                              boolean agreement,
	                              Model model,
	                              HttpSession session) {
		
		try {
			
			if (!agreement) {
				System.out.println("You have not agreed the Terms and Conditions");
				throw new Exception("You have not agreed the Terms and Conditions");
			}
			
			if(result1.hasErrors()) {
				System.out.println("ERROR : "+result1.toString());
				model.addAttribute("manager", manager);
				return "signup";
			}
			
			manager.setRole("ENGINEERING_MANAGER");
			manager.setEnabled(true);
			manager.setImageUrl("default.png");
			
			
			System.out.println("Agreement : "+agreement);
			System.out.println("Manager : "+manager);
			
			Manager result= this.managerRepository.save(manager);
			
			model.addAttribute("manager", new Manager());
			
			session.setAttribute("message", new Message("Sucessfully registered !!","alert-success"));
			return "signup";
			
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("manager", manager);
			session.setAttribute("message", new Message("Somethig went wrong.."+e.getMessage(), "alert-danger"));
			return "signup";
		}
		
	}
	
}
