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
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String customerId;
	private String customerFirstName;
	private String cutomerMiddleName;
	private String customerLastName;
	private String customerDataOfBirth;
	private String customerEmail;
	private Double cutomerMobileNumber;
	private Double cutomerAdditionalMobileNumber;
	private String customerGender;
	private Double customerTotalLoanRequired;
	private String customerVerificationStatus;
	

	
	
	//Secondary referance
	private CustomerAddress customerAddress;
	private Profession customerProfession;
	private Documents customerDocuments;
	private Cibil customerCibilScore;
	private CustomerAccountDetails customerAccountDetails;
	private Dealer dealerData;
	private Vehicle vehicleData;
	private GuarantorDetails guarantorDetails;
	private LoanDisbursement loanDisbursement;
	private Ledger ledger;
	private SanctionLetter sanctionLetter;
	
	
	
	
	
	
	
	
	

}
