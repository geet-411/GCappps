package com.GCappps.loanFin.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.NonFinal;
@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
public class CustomerAddress {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String customerAddressId;
	
	//Secondary
	private PermanentAddress customerPermanentAddress;
	private LocalAddress customerLocalAddress;
	

}
