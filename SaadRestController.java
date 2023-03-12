package com.exampleSaad.Saad;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.exampleSaad.Saad.SaadDatabaseconnect;

import com.exampleSaad.Saad.Register;

public class SaadRestController {

	@Autowired
	SaadDatabaseconnect db;
	
	// LOGIN PAGE
	
	@GetMapping("/Logins")
	 public String login(HttpServletRequest request, HttpSession session) {
		 session.setAttribute(
		         "error", getErrorMessage(request, "SPRING_SECURITY_LAST_EXCEPTION")
		      ); 
	 		return "Logins";
	 	 }
	
	
	
	// REGISTER PAGE
	
	 @GetMapping("/")
	 public String homepage(Model model) {
	 	Register register =new Register();
	 	model.addAttribute("register", register);
	 		return "index";
	 	 }
	 
	 @PostMapping("/register")
	 public String createRegister(@ModelAttribute("register") Register reg,Model model) {
	 		 
	 		
	 		if(db.insertRegister(reg)>=1)
	 			model.addAttribute("message", "Employee Added");
	 		else
	 			model.addAttribute("message", "Employee Failed");
	 		
	 		return "redirect:/register";
	 		
	 		
	 	 }
	 
	 // I DON'T KNOW THIS METHOD
	 
	 private String getErrorMessage(HttpServletRequest request, String key) {
	      Exception exception = (Exception) request.getSession().getAttribute(key); 
	      String error = ""; 
	      if (exception instanceof BadCredentialsException) { 
	         error = "Invalid username and password!"; 
	      } else if (exception instanceof LockedException) { 
	         error = exception.getMessage(); 
	      } else { 
	         error = "Invalid username and password!"; 
	      } 
	      return error;
	   }
	 
	
}
