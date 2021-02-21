package com.example.cricket.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.cricket.model.Users;
import com.example.cricket.request.LoginRequest;
import com.example.cricket.request.SignUpRequest;
import com.example.cricket.response.JwtLoginResponse;
import com.example.cricket.response.MessageAndStatusResponse;
import com.example.cricket.service.AuthenticationService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	AuthenticationService authenticationService;

	
	@PostMapping("/login")
	public JwtLoginResponse login(@RequestBody LoginRequest loginRequest) {
		return authenticationService.authenticateUser(loginRequest);
	}

	@PostMapping("/signUp")
	public MessageAndStatusResponse signUp(@RequestBody SignUpRequest newUser) {
		return authenticationService.signUpUser(newUser);
	}

	@PostMapping("/adminRegister")
	public MessageAndStatusResponse registerAdmin(@RequestParam String email) throws MailException, MessagingException {
		return authenticationService.registerAdmin(email);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/adminUpdate")
	public Users updateAdmin(@RequestBody SignUpRequest request) {
		return authenticationService.updateAdmin(request);
	}

	@PostMapping("/logout")
	public MessageAndStatusResponse logout() {
		return authenticationService.logout();
	}
}
