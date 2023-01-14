package com.GCappps.loanFin.app.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//validators added---------------------------------------
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer {
	@Id
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

	// Secondary referance

	@OneToOne(cascade = CascadeType.ALL)
	private CustomerAddress customerAddress;

	@OneToOne(cascade = CascadeType.ALL)
	private Profession customerProfession;

	@OneToOne(cascade = CascadeType.ALL)
	private Documents customerDocuments;

	@OneToOne(cascade = CascadeType.ALL)
	private Cibil customerCibilScore;

	@OneToOne(cascade = CascadeType.ALL)
	private CustomerAccountDetails customerAccountDetails;

	@OneToOne(cascade = CascadeType.ALL)
	private Dealer dealerData;

	@OneToOne(cascade = CascadeType.ALL)
	private Vehicle vehicleData;

	@OneToOne(cascade = CascadeType.ALL)
	private GuarantorDetails guarantorDetails;

	@OneToOne(cascade = CascadeType.ALL)
	private LoanDisbursement loanDisbursement;

	@OneToOne(cascade = CascadeType.ALL)
	private Ledger ledger;

	@OneToOne(cascade = CascadeType.ALL)
	private SanctionLetter sanctionLetter;

}
