package com.hcl.bankmanagementapp.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.bankmanagementapp.api.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


}
