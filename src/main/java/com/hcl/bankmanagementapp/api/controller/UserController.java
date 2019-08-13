package com.hcl.bankmanagementapp.api.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.bankmanagementapp.api.dto.LoginDTO;
import com.hcl.bankmanagementapp.api.dto.TransactionSummaryDto;
import com.hcl.bankmanagementapp.api.service.UserService;

@RestController
@CrossOrigin(allowedHeaders = { "*", "/" }, origins = { "*", "/" })
@RequestMapping("/bank")
public class UserController {

	private static final Logger logger =  LoggerFactory.getLogger(UserController.class);
@Autowired UserService userService;

@PostMapping("/login")
public ResponseEntity<List<TransactionSummaryDto>> loginUser(@RequestBody LoginDTO loginDTO){

	logger.info("inside the login method in controller.. ");
	
	List<TransactionSummaryDto> list =  userService.userLogin(loginDTO);
	
	return new ResponseEntity<List<TransactionSummaryDto>>(list, HttpStatus.OK);
	
}
	
}
