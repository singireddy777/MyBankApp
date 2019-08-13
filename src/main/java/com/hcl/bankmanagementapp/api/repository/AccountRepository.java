package com.hcl.bankmanagementapp.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.bankmanagementapp.api.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
