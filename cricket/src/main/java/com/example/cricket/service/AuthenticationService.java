package com.example.cricket.service;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.mail.MailException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.cricket.jwt.JwtUtils;
import com.example.cricket.model.ERoles;
import com.example.cricket.model.Role;
import com.example.cricket.model.Users;
import com.example.cricket.repository.RolesRepo;
import com.example.cricket.repository.UsersRepository;
import com.example.cricket.request.LoginRequest;
import com.example.cricket.request.SignUpRequest;
import com.example.cricket.response.JwtLoginResponse;
import com.example.cricket.response.MessageAndStatusResponse;
import com.example.cricket.security.UserDetailsImpl;


@Service
public class AuthenticationService {
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	JwtUtils jwtUtils;
	
	@Autowired
	UsersRepository usersRepo;
	
	@Autowired
	MailService mailService;
	
	@Autowired
	PasswordService passwordService;
	
	@Autowired
	RolesRepo roleRepo;

	@Autowired
	private PasswordEncoder encoder;
	
	Random random = new Random();
	
	public JwtLoginResponse authenticateUser(LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		
		return new JwtLoginResponse(userDetails.getName(), userDetails.getImagePath(),jwt, userDetails.getEmail(), HttpStatus.OK);
	
	}
	
	public MessageAndStatusResponse signUpUser(SignUpRequest newUser)
	{
		String email = newUser.getEmail();
		if(usersRepo.existsByEmail(email))
		{
			return new MessageAndStatusResponse("Email already exists", HttpStatus.OK);
		}
		
		String password = newUser.getPassword();
		String encryptedPwd = encoder.encode(password);
		Users user = new Users(newUser.getName(), newUser.getEmail(),encryptedPwd , newUser.getCountryCode(), newUser.getPhoneNumber(),
				newUser.getCity(), newUser.getGender(), newUser.getImagePath());
	
		Set<Role> role = new HashSet<>();
		Role userRole = roleRepo.findByName(ERoles.ROLE_USER).get();
				
		role.add(userRole);
		user.setRoles(role);
		usersRepo.save(user);
		return new MessageAndStatusResponse("User registered successfully", HttpStatus.OK);
	}
	
	public MessageAndStatusResponse registerAdmin(String email) throws MailException, MessagingException
	{
		Users user = new Users();
		
		String password = passwordService.generatePassword();
		String subject = "Admin Credentials";
		String body = "Username :"+email+"---- Password :"+password;
		
		mailService.sendEmail(email, subject, body);
		
		String encPassword = encoder.encode(password);
	
		Set<Role> role = new HashSet<>();
		Role userRole = roleRepo.findByName(ERoles.ROLE_ADMIN).get();
				
		role.add(userRole);
		user.setRoles(role);
		
		user.setEmail(email);
		user.setPassword(encPassword);
		usersRepo.save(user);
		
		return new MessageAndStatusResponse("Admin added successfully", HttpStatus.OK);
	}
	
	public Users updateAdmin(SignUpRequest request)
	{
		Users user = usersRepo.findByEmail(request.getEmail());
		user.setCity(request.getCity());
		user.setCountryCode(request.getCountryCode());
		user.setGender(request.getGender());
		user.setImagePath(request.getImagePath());
		user.setName(request.getName());
		user.setPhoneNumber(request.getPhoneNumber());
		
		usersRepo.save(user);
		return user;
		
	}
	
}
