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
public class Ledger {
	@Id
	private String ledgerId;
	private String ledgerCreatedDate;
	private Double totalLoanAmount;
	private Double payableAmountWithInterest;
	private Integer tenure;
	private Double monthlyEMI;
	private Double amountPaidTillDate;
	private Integer remainingAmount;
	private String nextEMIDateStart;
	private String nextEMIDateEnd;
	private Integer defaulterCount;
	private String previousEMIStatus;
	private String loanEndDate;
	private String loanStatus;

	

}
