package com.hcl.bankmanagementapp.api.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="transaction_detail")
@Data
public class TransactionSummary implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private long transactionId;
	private String merchantName;
	private double amount;
	private long accountNO;
	private String transactionDate;
	private String status;

}
