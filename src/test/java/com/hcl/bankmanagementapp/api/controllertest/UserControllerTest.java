package com.hcl.bankmanagementapp.api.controllertest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.bankmanagementapp.api.controller.UserController;
import com.hcl.bankmanagementapp.api.dto.LoginDTO;
import com.hcl.bankmanagementapp.api.dto.TransactionSummaryDto;
import com.hcl.bankmanagementapp.api.entity.User;
import com.hcl.bankmanagementapp.api.service.UserServiceImpl;

@RunWith(MockitoJUnitRunner.class)

public class UserControllerTest {

	@Mock
	UserServiceImpl userServiceImpl;
	@InjectMocks
	UserController userController;
	private MockMvc mockmvc;
	User user;
	
	@Before
	public void setUp() {
		user= new User();
	user.setAcct_no(9877L);
	user.setEmail_id("abc@gmail");
	user.setFirst_name("venkat");
	user.setLast_name("vensee");
	user.setMessage("success");
	user.setMobile_no("897888");
	user.setPassword("password");
	
		mockmvc = MockMvcBuilders.standaloneSetup(userController).build();	
	}
	
	@Test
	public void UserLoginTest() throws Exception{
		
		LoginDTO loginDTO = new LoginDTO();
		
		List<TransactionSummaryDto> list = new ArrayList();
		TransactionSummaryDto transactionSummaryDto= new TransactionSummaryDto();
		transactionSummaryDto.setAccountNO(9779L);
		transactionSummaryDto.setAmount(7979739);
		transactionSummaryDto.setMerchantName("venkat");
		transactionSummaryDto.setStatus("success");
		transactionSummaryDto.setTransactionDate("13-08-2019");
		list.add(transactionSummaryDto);
		
		loginDTO.setAcct_no(987797L);
		loginDTO.setPassword("password");
		
		Mockito.when(userServiceImpl.userLogin(loginDTO)).thenReturn(list);
		
		mockmvc.perform(MockMvcRequestBuilders.post("/bank/login").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.ALL).content(asJsonString(loginDTO)));
		
		ResponseEntity<List<TransactionSummaryDto>>	list1 =  userController.loginUser(loginDTO);
		
		System.out.println("list1 : "+list1);
		    
		    assertEquals(list, list1.getBody());
		
	}
	public static String asJsonString(final Object object) {
		try {
			return new ObjectMapper().writeValueAsString(object);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
}}
