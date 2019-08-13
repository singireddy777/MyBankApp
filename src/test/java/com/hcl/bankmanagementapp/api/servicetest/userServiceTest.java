package com.hcl.bankmanagementapp.api.servicetest;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.BeanUtils;

import com.hcl.bankmanagementapp.api.dto.LoginDTO;
import com.hcl.bankmanagementapp.api.dto.TransactionSummaryDto;
import com.hcl.bankmanagementapp.api.entity.TransactionSummary;
import com.hcl.bankmanagementapp.api.entity.User;
import com.hcl.bankmanagementapp.api.repository.TransactionSummaryRepository;
import com.hcl.bankmanagementapp.api.repository.UserRepository;
import com.hcl.bankmanagementapp.api.service.UserServiceImpl;


@RunWith(MockitoJUnitRunner.class)
public class userServiceTest {
	
@Mock
UserRepository userRepo;

@InjectMocks
UserServiceImpl userServiceImpl;
@Mock
TransactionSummaryRepository transactionSummaryRepository;
@Test
public void userLoginTest() {
	
	User user = new User();
	
	
	TransactionSummary transactionSummary=new TransactionSummary();
	transactionSummary.setAccountNO(98786L);
	transactionSummary.setAmount(5478);
	transactionSummary.setMerchantName("sairam");
	transactionSummary.setStatus("success");
	transactionSummary.setTransactionDate("13-08-2019");
	transactionSummary.setTransactionId(13);
	
	List<TransactionSummary> summary = new ArrayList();
	summary.add(transactionSummary);
	
	LoginDTO loginDTO = new LoginDTO();
	loginDTO.setAcct_no(9879L);
	loginDTO.setPassword("password");
	
	user.setAcct_no(876543L);
	user.setPassword("password");
	user.setEmail_id("abc@gmail");
	user.setFirst_name("venkat");
	user.setLast_name("reddy");
	user.setMessage("success");
	user.setMobile_no("9877897");
	
	/*user.setAcct_no(9087809);
	user.setEmail_id("abc@gmail");
	user.setFirst_name("venkat");
	user.setLast_name("reddy");
	user.setMessage("success");
	user.setMobile_no("973923");
	user.setPassword("password");*/
	
	//BeanUtils.copyProperties(user, loginDTO);
	
	Mockito.when(userRepo.findById(Mockito.anyLong())).thenReturn(Optional.of(user));
	Mockito.when(transactionSummaryRepository.findAll()).thenReturn(summary);
	List<TransactionSummaryDto> result = userServiceImpl.userLogin(loginDTO);
	
	assertEquals(summary.get(0).getAccountNO(), result.get(0).getAccountNO());
	
	
	
	
	
}
}
