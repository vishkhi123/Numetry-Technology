package com.sms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sms.entity.User;
import com.sms.exception.SMSServiceException;
import com.sms.repository.UserRepository;
import com.sms.service.SMSService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private SMSService smsService;
	
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        
       User saved=this.userRepository.save(user);

        // Send SMS after successful registration
        try {
            smsService.sendSMS(user.getPhoneNumber(), "Thank you for registering!");
        } catch (SMSServiceException e) {
            // Handle SMS sending failure
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Failed to send SMS");
        }

        return ResponseEntity.ok("User registered successfully!");
    }

}
