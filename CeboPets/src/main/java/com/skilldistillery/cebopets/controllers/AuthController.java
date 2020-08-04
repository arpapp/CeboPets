package com.skilldistillery.cebopets.controllers;

import java.security.Principal;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.cebopets.entities.User;
import com.skilldistillery.cebopets.services.AuthService;

@RestController
@CrossOrigin({"*", "http://localhost:4211"})
public class AuthController {
	
	@Autowired
	private AuthService authService;
	
	@PostMapping("/register")
	public User register(
			@RequestBody User user,
			HttpServletResponse res
	) {
		if (user == null) {
			res.setStatus(400);
		}
		
		user = authService.register(user);
		
		return user;
	}
	
	@GetMapping("/authenticate")
	// principal checks the username/pw - if they are valid depending on encoder
	public Principal authenticate(Principal principal) {
	    return principal;
	}
	

}
