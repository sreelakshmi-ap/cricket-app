package com.example.cricket.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.cricket.model.LiveUpdate;
import com.example.cricket.model.Users;
import com.example.cricket.repository.UsersRepository;
import com.example.cricket.request.OtpRequest;
import com.example.cricket.response.MainResponse;
import com.example.cricket.service.AuthenticationService;
import com.example.cricket.service.ForgotPasswordService;
import com.example.cricket.service.LiveUpdateService;
import com.example.cricket.service.MailService;





@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/ForgotPassword")
public class ForgotPassword {
	
	@Autowired
	ForgotPasswordService otpService;
	
	
	@Autowired
	UsersRepository usersRepo;
	
	@Autowired
	MailService emailService;
	

	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	@Autowired
	AuthenticationService authenticationService;
	
	@Autowired
	LiveUpdateService testing;

	
	
	@RequestMapping(value = "/GenerateOTP", method = RequestMethod.POST)
	public ResponseEntity<?> generateOTP(@RequestBody OtpRequest otpRequest) throws Exception{
			String email = otpRequest.getEmail();
			if(!(usersRepo.existsByEmail(email))) {
				return ResponseEntity.status(200).body(new MainResponse(204,"EMAIL NOT FOUND PLEASE CREATE ACCOUNT",""));
				}
			int otp = otpService.generateOTP(email);
			emailService.sendEmail(email, "Your requested OTP", "otp = "+otp);
			return ResponseEntity.status(HttpStatus.CREATED).body(new MainResponse(200,"Success",""));
	}
	
	

	@PutMapping("/ValidateOTP")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> validateOTP(@RequestBody OtpRequest otpRequest ) {
		String email = otpRequest.getEmail();
		if(!(usersRepo.existsByEmail(email))) {
			return ResponseEntity.status(200).body(new MainResponse(204,"EMAIL NOT FOUND PLEASE CREATE ACCOUNT",""));
		}
		long otpnum = otpRequest.getOtpNumber();
		if(otpnum >=100000){
			
			  long serverOtp = otpService.getOtp(email);
			    if(serverOtp > 100000){
			      if(otpnum == serverOtp){
			          otpService.clearOTP(email);			
			      	return ResponseEntity.status(200).body(new MainResponse(200,"OTP VALIDATED SUCCESSFULLY",""));
	                } 
			        else {
			        	return ResponseEntity.status(401).body(new MainResponse(500,"OTP IS INVALID",""));
	                   }
	               }else {
	            	   return ResponseEntity.status(401).body(new MainResponse(401,"TIME EXPIRED OR OTP IS ALREADY USED"," "));
	               }
	             }else {
	            	 return ResponseEntity.status(401).body(new MainResponse(401,"ENTERED VALID NUMBER OF OTP DIGITS",""));
	         }
	}
	
	
	@PutMapping("/changePassword")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> changePassword(@RequestBody Users userValue) {
		try {

			if (!(usersRepo.existsByEmail(userValue.getEmail()))) {
				return ResponseEntity.status(200).body(new MainResponse(204, "EMAIL NOT FOUND",""));
			}
			Users user = usersRepo.findByEmail(userValue.getEmail());
			user.setPassword(bcryptEncoder.encode(userValue.getPassword()));
			usersRepo.save(user);

		} catch (NoSuchElementException e) {
			return ResponseEntity.status(204).body(new MainResponse(204, "EMAIL NOT FOUND"," " ));

		}
		return ResponseEntity.status(200).body(new MainResponse(200,"PASSWORD UPDATED SUCCESSFULLY"," "));
	}

		
	@GetMapping("/testing")
	@ResponseStatus(HttpStatus.CREATED)
	public int testing(@RequestParam int value)  {
		int kk= testing.maidenOver(1, 1, 1, 2);
		System.out.println("finnnnnnnne....."+kk);
		return kk;
	}
}
