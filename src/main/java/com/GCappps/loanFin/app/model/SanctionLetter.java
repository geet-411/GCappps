package com.GCappps.loanFin.app.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SanctionLetter {

	@Id
	private String sanctionId;
	private String sanctionDate;
	private String applicantName;
	private Double contactDetails;
	private Double loanAmountSanctioned;
	private String interestType;
	private Double rateOfInterest;
	private Integer loanTenure;
	private Double monthlyEmiAmount;
	private String modeOfPayment;
	private String termsAndConditions;
	private String sanctionLetterStatus;
	
	
	
	
	
	


}
