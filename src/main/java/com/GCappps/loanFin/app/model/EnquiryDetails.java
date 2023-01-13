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
public class EnquiryDetails {
	

	
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private String customerEnquiryId;
		private String customerFirstName;
		private String customerMiddleName;
		private String customerLastName;
		
		private String customerDataOfBirth;
		private String customerEmail;
		private Double cutomerMobileNumber;
		private String customerPancardNumber;
		private String cutomerEnquiryStatus;
		



	}


