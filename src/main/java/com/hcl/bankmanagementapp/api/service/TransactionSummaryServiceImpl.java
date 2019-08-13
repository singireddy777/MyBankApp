package com.hcl.bankmanagementapp.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.bankmanagementapp.api.repository.AccountRepository;
import com.hcl.bankmanagementapp.api.repository.UserRepository;

@Service
public class TransactionSummaryServiceImpl implements ITransactionSummaryService {
	
	@Autowired
	AccountRepository accountRepository;
	@Autowired
	UserRepository userRepository;
	@Override
	public String fundTransfer(long merchantNo, double amount) {
		
		
		return null;
	}

}
