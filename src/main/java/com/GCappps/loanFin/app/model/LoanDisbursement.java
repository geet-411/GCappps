package com.GCappps.loanFin.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class LoanDisbursement {
	@Id
	private String loanId;
	private String amountPayType;
	private Double totalAmount;
	private String bankName;
	private String dealarAccountNumber;
	private String dealerIFSCCode;
	private String dealerAccountType;
	private String paymentStatus;
	private Double transferAmount;
	private String amountPaidDate;
	

}
