package com.example.ordini.gesOrdini.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.ordini.gesOrdini.model.Utenti;
import com.example.ordini.gesOrdini.service.LoginService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService service;
	
	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}
	
	@PostMapping("/login")
	public String login(String username, String password, HttpSession session, HttpServletRequest request) {

	    Utenti u = service.login(username, password);

	    if(u != null) {
	        session.setAttribute("utente", u);

	        return "redirect:/ordini";
	    }

	    return "login";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		
		session.invalidate();
		
		return "redirect:/login";
	}
   
	
}
